package com.pgy.io;

import org.apache.commons.io.FilenameUtils;

public class FileNameApi {
    public static void main(String[] args) {
        String dir = "/user/home";
        String name = "test";
        String pattern = ".tgz";

        System.out.println(FilenameUtils.concat(name, pattern));
    }
}
