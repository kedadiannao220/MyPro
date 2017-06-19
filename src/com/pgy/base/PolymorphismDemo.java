package com.pgy.base;

/**
 * 构造器内部的多态方法的行为
 * 构造方法调用内部的方法时，会执行所创建对象的内部方法
 * @author admin
 * @version $Id: PolymorphismDemo.java, v 0.1 2015年9月1日 上午8:30:31 admin Exp $
 */
class Person {
    void run() {
        System.out.println("Person run");
    }

    Person() {
        System.out.println("Person run before student");
        run();//当子类继承父类的构造方法的时候，此处调用的run，是创建对象student的run方法，而不是父类的run方法，因为父类对象没有被创建
        System.out.println("Person run after student");
    }
}

class Student extends Person {
    private int age = 1;

    //当父类调用此方法的时候，age没有被初始化，内存分配给age初始化的二进制0
    void run() {
        System.out.println("Student run method, age = " + age);
    }

    Student(int age) {
        System.out.println("Student run construct,age = " + age);
    }
}

public class PolymorphismDemo {

    public static void main(String[] args) {
        new Student(10);
    }
}

/*console*/
//Person run before student
//Student run method, age = 0
//Person run after student
//Student run construct,age = 10

