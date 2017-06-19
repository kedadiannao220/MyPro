package com.pgy.base.jdk;

import java.util.regex.Pattern;

/**
 * Created by admin on 17/01/2017.
 */
public class PatternTest {

    public static void main(String[] args) {

        Pattern patter = Pattern.compile("\\d{1,5}([,]\\d{1,5})?");
        System.out.println(patter.matcher("30,20").matches());
    }
}
