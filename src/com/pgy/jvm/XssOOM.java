package com.pgy.jvm;

/**
 * Xss参数测试OOM异常
 * 
 * -Xss2M
 * Created by admin on 19/06/2017.
 */
public class XssOOM {

    public static void stopThread() {
        while (true) {

        }
    }

    public static void threadNew() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    stopThread();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        System.out.println("Total Memroy: " + Runtime.getRuntime().totalMemory() / 1024 / 1024);
        System.out.println("Max Memory: " + Runtime.getRuntime().maxMemory() / 1024 / 1024);
        System.out.println("Free Memroy: " + Runtime.getRuntime().freeMemory() / 1024 / 1024);

        XssOOM xssOOM = new XssOOM();
        xssOOM.threadNew();

    }
}
