package com.pgy.hackerRank;

import java.util.Scanner;

public class StdinAndStout {
    public static void main(String[] args) {
        //        readInteger();
        readData();
    }

    private static void readInteger() {
        Scanner sc = new Scanner(System.in);

        System.out.println(sc.nextInt());
        System.out.println(sc.nextInt());
    }

    private static void readData() {
        Scanner sc = new Scanner(System.in);

        System.out.println(sc.nextInt());
        System.out.println(sc.nextDouble());
        sc.nextLine();
        System.out.println(sc.nextLine());

    }
}
