package com.pgy.io;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MD5Api {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/admin/projects/emacsProject/aa.org");
        String test = "bb";
        System.out.println(md5Hash(file));
        System.out.println(md5Hash(test));
        System.out.println(md5Check(test, "5a5130fab3ace7fda642fa9db76eb237"));
    }

    public static final String md5Hash(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        return DigestUtils.md5Hex(fis);
    }

    public static final String md5Hash(String str) {
        byte[] srtbyte = str.getBytes();
        return DigestUtils.md2Hex(srtbyte);
    }

    public static Boolean md5Check(String md5Str, String md5Pwd) {
        String password = md5Hash(md5Str);
        return password.equals(md5Pwd);

    }

    public static Boolean md5Check(File file, String md5Pwd) throws IOException {
        String password = md5Hash(file);
        return password.equals(md5Pwd);
    }

}