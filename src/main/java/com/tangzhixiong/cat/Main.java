package com.tangzhixiong.cat;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void printLines(List<String> lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static void dumpLines(List<String> lines, String outputPath) {
        File file = new File(outputPath);
        try (
                FileOutputStream fos = new FileOutputStream(file);
        ) {
            for (String line : lines) {
                fos.write(line.getBytes());
                // fos.write(System.lineSeparator().getBytes());
                fos.write("\n".getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            // hacks copied from StackOverflow: http://stackoverflow.com/questions/361975/setting-the-default-java-character-encoding
            System.setProperty("file.encoding", "UTF-8");
            Field charset = Charset.class.getDeclaredField("defaultCharset");
            charset.setAccessible(true);
            charset.set(null, null);
        } catch (Exception e) {
        }

        if (args.length < 1) {
            System.out.println("Usage: java -jar cat.jar FILENAME");
            printLines(Cat.cat("test/a.txt"));
            return;
        }
        printLines(Cat.cat(args[0]));
    }
}
