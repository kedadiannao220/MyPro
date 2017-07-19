package com.pgy.jvm.jvmOptions;

/**
 * Xss参数测试OOM异常与SOE异常
 *
 *  -Xss160k
 * Created by admin on 19/06/2017.
 */
public class XssSOE {
    static int i = 0;

    public static void count() {
        i++;
        count();
    }

    public static void main(String[] args) {

        System.out.println("Total Memroy: " + Runtime.getRuntime().totalMemory() / 1024 / 1024);
        System.out.println("Max Memory: " + Runtime.getRuntime().maxMemory() / 1024 / 1024);
        System.out.println("Free Memroy: " + Runtime.getRuntime().freeMemory() / 1024 / 1024);

        try {
            count();
        } catch (Throwable e) {
            /**
             * Total Memroy: 123
             * Max Memory: 1820
             * Free Memroy: 117
             * i值为:825,操作异常:java.lang.StackOverflowError
             */
            System.out.println("i值为:" + i + ",操作异常:" + e);
        }
    }
}
