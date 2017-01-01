package com.tangzhixiong.cat;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tzx on 2016/12/30.
 */
public class Cat {
    final private static Pattern p = Pattern.compile("^( *)([%@])\\2include <([-/])=([^=]*)=$");

    public static List<String> cat(String filename) {
        File file = new File(filename);
        if (!file.exists() || !file.isFile() || !file.canRead()) {
            String err = "Error openning file: ["+filename+"].";
            System.err.println(err);
            return new ArrayList<>();
        }
        try {
            return unfoldLines("", file, false, new LinkedHashSet<String>());
        } catch (Exception e) {
        }
        return new ArrayList<>();
    }

    // file is 100% readable
    private static List<String> preserveLines(File file, boolean shave) {
        ArrayList<String> lines = new ArrayList<>();
        try (
                Scanner scanner = new Scanner(file);
        ) {
            if (shave && scanner.hasNext()) {
                String f = scanner.nextLine();
                if (f.equals("---")) {
                    while(scanner.hasNextLine()) {
                        if (scanner.nextLine().equals("---")) { break; }
                    }
                    if (scanner.hasNextLine()) {
                        String b = scanner.nextLine();
                        if (!b.isEmpty()) {
                            lines.add(b);
                        }
                    }
                } else {
                    lines.add(f);
                }
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }
        } catch (Exception e) {}
        return lines;
    }

    // file is 100% readable
    private static List<String> unfoldLines(String padding, File file, boolean shave, LinkedHashSet<String> filenames) {
        ArrayList<String> lines = new ArrayList<>();
        String filename = null;
        try {
            filename = file.getCanonicalPath().replace("\\", "/");
        } catch (Exception e) {
            return lines;
        }
        if (filenames.contains(filename)) {
            List<String> moreLines = preserveLines(file, shave);
            for (String moreLine : moreLines) {
                lines.add(padding+moreLine);
            }
            return lines;
        }
        try (
                Scanner scanner = new Scanner(file);
        ) {
            filenames.add(filename);
            if (shave && scanner.hasNext()) {
                String f = scanner.nextLine();
                if (f.equals("---")) {
                    while(scanner.hasNextLine()) {
                        if (scanner.nextLine().equals("---")) { break; }
                    }
                    if (scanner.hasNextLine()) {
                        String b = scanner.nextLine();
                        if (!b.isEmpty()) {
                            lines.add(b);
                        }
                    }
                } else {
                    lines.add(f);
                }
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.endsWith("=")) {
                    Matcher m = p.matcher(line);
                    if (m.find()) {
                        String pd = m.group(1);
                        String sv = m.group(3);
                        String fn = m.group(4);
                        if (!fn.toLowerCase().matches("^[a-z]:.*") && !fn.startsWith("/")) {
                            // fn = file.getParentFile().getCanonicalPath() + File.separator + fn; // BUGGY
                            fn = filename.substring(0, filename.lastIndexOf("/"))+"/"+fn;
                        }
                        switch (m.group(2)) {
                            case "@@": case "%%":
                                lines.add(padding+pd+m.group(2)+"include <"+sv+"="+m.group(4)+"=");
                                break;
                            case "@": {
                                File f = new File(fn);
                                if (!f.exists() || !f.isFile() || !f.canRead()) {
                                    String err = "Error openning file: ["+m.group(4)+"].";
                                    System.err.println(err);
                                    lines.add(padding+pd+err);
                                } else {
                                    List<String> moreLines = unfoldLines("", f, sv.equals("/"), filenames);
                                    for (String moreLine : moreLines) {
                                        lines.add(padding+pd+moreLine);
                                    }
                                }
                            } break;
                            case "%": {
                                File f = new File(fn);
                                if (!f.exists() || !f.isFile() || !f.canRead()) {
                                    String err = "Error openning file: ["+m.group(4)+"].";
                                    System.err.println(err);
                                    lines.add(padding+pd+err);
                                } else {
                                    List<String> moreLines = preserveLines(f, sv.equals("/"));
                                    for (String moreLine : moreLines) {
                                        lines.add(padding+pd+moreLine);
                                    }
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
