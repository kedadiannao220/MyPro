package com.pgy.io;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileConvert {
    public static void main(String[] args) {
        convert();
    }

    private static File convert() {
        try {
            File srcFile = new File("/Users/admin/Desktop/wkBible.csv");

            String content = FileUtils.readFileToString(srcFile);
            System.out.println(content.substring(0, 1000));
            byte[] iso8859 = StringUtils.getBytesIso8859_1(content);
            String utf8 = StringUtils.newStringUtf8(iso8859);
            System.out.println(utf8.substring(0, 1000));
            File targetFile = new File("/Users/admin/Desktop/wkBible2.csv");
            //            FileUtils.writeStringToFile(targetFile, utf8, Charsets.UTF_8);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("success");
        return null;
    }
}
