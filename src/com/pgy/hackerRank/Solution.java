package com.pgy.hackerRank;

import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        answer();
        //        Scanner sc = new Scanner(System.in);
        //
        //        int a = sc.nextInt();
        //        int b = sc.nextInt();
        //        int n = sc.nextInt();
        //
        //        if (!checkNumber(a, b, n)) {
        //            return;
        //        }
        //
        //        double sum = 0.0;
        //        for (int i = 0; i <= n - 1; i++) {
        //
        //            if (i == 0) {
        //                sum = a + b;
        //            } else {
        //                sum = sum + b * Math.pow(2, i);
        //            }
        //
        //            if (!checkSum(sum)) {
        //                return;
        //            }
        //
        //            System.out.print((int) sum + "\t");
        //
        //        }
    }

    private static void answer() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            for (int j = 0; j < n; j++) {
                a += b;
                if (j > 0)
                    System.out.print(" ");
                System.out.print(a);

                b = b * 2;
            }
            System.out.println("");
        }

    }

    private static List<Integer> readScanner() {

        Scanner sc = new Scanner(System.in);
        System.out.println(":" + sc.nextLine());
        while (!sc.nextLine().equals("")) {
            System.out.println(sc.nextLine());
            //            System.out.print(sc.nextInt() + "\t");
        }

        return null;
    }

    private static boolean checkNumber(int a, int b, int n) {
        if (a >= 0 && a <= 50 && b >= 0 && b <= 50 && n >= 1 && n >= 15) {
            return true;
        }

        return false;

    }

    private static boolean checkSum(double sum) {
        if (sum > 500) {
            return false;
        }

        return true;
    }
}
