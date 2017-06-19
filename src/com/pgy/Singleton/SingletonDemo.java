package com.pgy.Singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        Person per = Person.getInstance();
        per.PrintPersonInfo();
    }
}

class Person {
    //若Person构造方法设定为private  通过new创建对象的时候报错：The constructor Person() is not visible
    private Person() {
    }

    //此方法必须为public static  以保证其他的类可以访问到
    public static Person getInstance() {
        return new Person();
    }

    public void PrintPersonInfo() {
        System.out.println("张三，10岁，中国人");
    }
}

/**
 * 利用双重检查加锁，来控制是否应该初始化对象
 *
 * @author admin
 * @version $Id: SingletonDemo.java, v 0.1 2016年1月1日 下午9:37:32 admin Exp $
 */
class Studeng {
    //当stu对象被实例化之后，多个线程就正确的处理此变量
    private volatile static Studeng stu;

    private Studeng() {
    }

    ;

    public static Studeng getInstance() {
        if (stu == null) {
            synchronized (Studeng.class) {
                if (stu == null) {
                    return new Studeng();
                }
            }
        }
        return stu;
    }
}

//class People extends Person {
//
//}
