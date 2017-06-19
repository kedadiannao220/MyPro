package com.pgy.base;

/**
 * 多态的Demo
 * 多态构造方法
 * @author admin
 * @version $Id: SandWichDemo.java, v 0.1 2015年8月31日 上午8:35:18 admin Exp $
 */
class Meal {
    /**
     * 父类的构造方法若为static类型，则子类不能够继承调用
     */
    public static void Meal() {
        System.out.println("meal method");
    }
}

class Bread {
    Bread() {
        System.out.println("bread method");
    }
}

class Cheese {
    Cheese() {
        System.out.println("cheese method");
    }
}

class Lettuce {
    Lettuce() {
        System.out.println("lettuce method");
    }
}

class Lunch extends Meal {
    Lunch() {
        System.out.println("lunch method");
    }
}

class PortableLunch extends Lunch {
    PortableLunch() {
        System.out.println("PortableLunch method");
    }
}

/**
 * 先会执行PortableLunch父类的构造方法；如果PortableLunch当中还存在继承那么会继续向上继承
 * 再执行自己声明的new 类
 * 最后执行自己的构造方法
 * @author admin
 * @version $Id: SandWichDemo.java, v 0.1 2015年8月31日 上午8:45:21 admin Exp $
 */
public class SandWichDemo extends PortableLunch {

    private Bread   b = new Bread();
    private Cheese  c = new Cheese();
    private Lettuce l = new Lettuce();

    /**
     * 当执行子类的构造方法的时候，需要先去调用父类所有的非private 非static的构造方法，然后才执行子类的构造方法
     */
    public SandWichDemo() {
        System.out.println("SandWichDemo method");
    }

    public static void main(String[] args) {
        new SandWichDemo();
    }
}
