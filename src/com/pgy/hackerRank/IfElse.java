package com.pgy.hackerRank;

import java.util.Scanner;

public class IfElse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        if (isOdd(num)) {
            System.out.println("Weird");
        } else {
            System.out.println(weiredValue(num));
        }

    }

    private static boolean isOdd(int num) {
        if (num % 2 == 0) {
            return false;
        }
        return true;
    }

    private static String weiredValue(int num) {
        if (num <= 20 && num > 6) {
            return "Weird";
        }
        return "Not Weird";
    }
}
