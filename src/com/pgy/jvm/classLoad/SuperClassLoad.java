package com.pgy.jvm.classLoad;

/**
 * Created by admin on 10/07/2017.
 */
public class SuperClassLoad {
    static int value = 1000;

    static {
        System.out.println("SuperClass init!");
    }
}

class SubClass extends SuperClassLoad {
    static {
        System.out.println("SubClass init!");
    }
}

class mainTest {
    public static void main(String[] args) {
        /**
         * 没有使用SubClass当中的属性,所以不会被加载,不会输出SubClass init
         * SuperClass init!
         * 1000
         */
        System.out.println(SubClass.value);
    }
}
