package com.pgy.base.jdk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 10/05/2017.
 */
public class StringTest {
    public static void main(String[] args) {
        String a = "a";
        String b = "a";

        System.out.println(a == b);
        System.out.println("a" == "a");
        System.out.println("a".equals("a"));

        System.out.println(8 >> 4);

        List list = new ArrayList<>();

        System.out.println(list.get(0));
        System.out.println(list.size());
    }
}
