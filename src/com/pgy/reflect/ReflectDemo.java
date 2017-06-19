package com.pgy.reflect;

/**
 * 此方法用于测试Field Method Construct方法
 *
 * @author admin
 * @version $Id: ReflectDemo.java, v 0.1 2015年9月24日 下午12:55:55 admin Exp $
 */

class Person {
    /** className 注释 */
    private static final String sex = "男";
    /** className 注释 */
    public static int    age;
    /** className 注释 */
    public static String name;

    public Person(String name, int age) {
        System.out.println("name:" + name + "age" + age);
    }

    public static int getAge() {
        return age;
    }

    public static String getName() {
        return name;
    }

    public static void setAge(int age) {
        Person.age = age;
    }

    public static void setName(String name) {
        Person.name = name;
    }

}

interface Student {
    public void println();
}

public class ReflectDemo implements Student {
    /** className 注释 */
    public static String className = "ReflectDemo";

    /**  classType 注释*/
    public static final String classType = "public";

    @Override public void println() {
        System.out.println("this is Student implements");
    }

}
