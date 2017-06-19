package com.pgy.hackerRank;

import java.util.Scanner;

/**
 * 题目地址：https://www.hackerrank.com/challenges/java-output-formatting
 * @author admin
 * @version $Id: OutputFormatting.java, v 0.1 2016年2月1日 下午10:38:59 admin Exp $
 */
public class OutputFormatting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String str = sc.next();
            int num = sc.nextInt();
            System.out.print(str);
            System.out.printf("%" + wordDiff(str) + "s", processNum(num));
            System.out.println();
        }

        System.out.println("================================");
    }

    private static int wordDiff(String str) {
        return 18 - str.length();
    }

    private static String processNum(int num) {
        if (num > 999 || num < 0) {
            System.out.println("the num must between 0~999");
        }
        if (num < 10) {
            return "00" + num;
        }

        if (num < 100) {
            return "0" + num;
        }

        return num + "";
    }
}