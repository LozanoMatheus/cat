package com.tangzhixiong.cat;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tzx on 2016/12/30.
 */
public class Cat {
    final private static Pattern p = Pattern.compile("^( *)([%@]{1,2})include <-=(.*)=$");

    public static List<String> cat(String filename) {
        File file = new File(filename);
        if (!file.exists() || !file.isFile() || !file.canRead()) {
            return new ArrayList<>();
        }
        try {
            return unfoldLines("", file.getCanonicalPath(), new LinkedHashSet<String>());
        } catch (Exception e) {
        }
        return new ArrayList<>();
    }

    // filename should be a canonicalpath
    private static List<String> preserveLines(String filename) {
        ArrayList<String> lines = new ArrayList<>();
        File file = new File(filename);
        try (
                Scanner scanner = new Scanner(file);
        ) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }
        } catch (Exception e) {
            String err = "Error openning file: ["+filename+"].";
            System.err.println(err);
            lines.add(err);
        } finally {
            return lines;
        }
    }

    // filename should be a canonicalpath
    private static List<String> unfoldLines(String padding, String filename, LinkedHashSet<String> filenames) {
        ArrayList<String> lines = new ArrayList<>();
        File file = new File(filename);
        if (!file.exists() || !file.isFile() || !file.canRead()) {
            String err = "Error openning file: ["+filename+"].";
            System.err.println(err);
            lines.add(err);
            return lines;
        }
        try (
                Scanner scanner = new Scanner(file);
        ) {
            if (filenames.contains(filename)) {
                List<String> moreLines = preserveLines(filename);
                for (String moreLine : moreLines) {
                    lines.add(padding+moreLine);
                }
                return lines;
            }
            filenames.add(filename);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.endsWith("=")) {
                    Matcher m = p.matcher(line);
                    if (m.find() && m.groupCount() == 3) {
                        String pd = m.group(1);
                        String fn = m.group(3);
                        if (!fn.toLowerCase().matches("^[a-z]:.*") && !fn.startsWith("/")) {
                            fn = file.getParentFile().getCanonicalPath() + File.separator + fn;
                        }
                        switch (m.group(2)) {
                            case "@@": case "%%":
                                lines.add(padding+pd+m.group(2).substring(0,1)+"include <-="+m.group(3)+"=");
                                break;
                            case "@": {
                                List<String> moreLines = unfoldLines("", fn, filenames);
                                for (String moreLine : moreLines) {
                                    lines.add(padding+pd+moreLine);
                                }
                            } break;
                            case "%": {
                                List<String> moreLines = preserveLines(fn);
                                for (String moreLine : moreLines) {
                                    lines.add(padding+pd+moreLine);
                                }
                            } break;
                            default:
                                System.err.println("Unknown Error");
                        }
                        continue;
                    }
                }
                lines.add(padding+line);
            }
        } catch (Exception e) {
        }
        return lines;
    }
}