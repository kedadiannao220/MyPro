package com.pgy.base;

/**
 * 测试this关键字
 * @author admin
 * @version $Id: thisDemo.java, v 0.1 2015年8月31日 上午9:21:54 admin Exp $
 */
public class thisDemo {

    private int age;

    public thisDemo() {
        System.out.println(this);
    }

    public thisDemo(int age) {
        this();
        this.age = age;
        System.out.println(this.age);
    }

    public String toString() {
        return "ForgDemo2";
    }

    void getAge(int ageParam) {
        this.age = ageParam;
    }

    public static void main(String[] args) {
        new thisDemo(10);
    }
}
