package com.pgy.jvm.classLoad;

/**
 * Created by admin on 10/07/2017.
 */
public class ConstantLoad {
    public static final String CODE = "Java";

    static {
        System.out.println("ConstantLoad init!");
    }
}

class ConstantRef {
    public static void main(String[] args) {
        /**
         * 不会输出Constant init,因为CODE被放在了常量池当中
         */
        System.out.println(ConstantLoad.CODE);
    }
}
