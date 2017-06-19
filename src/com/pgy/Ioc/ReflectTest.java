package com.pgy.Ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {

    public static void main(String[] args) throws Throwable {
        //        initByDefaultConst();
        //        System.out.println("-----------------------");
        testCarReflect();

        //        testBean();
    }

    public static void testBean() {
        Car car = new Car();
        car.price = "hello";

        Car car2 = new Car();
        car2.price = "20";

        System.out.println(car.price);
        System.out.println(car2.price);

    }

    public static void initByDefaultConst() throws Throwable {

        //通过classLoader来加载指定包当中的class
        ClassLoader load = Thread.currentThread().getContextClassLoader();
        System.out.println(load);
        Class clazz = load.loadClass("com.Car");

        //通过无参的构造方法来实例化对象   相当于new Car()
        Constructor cons = clazz.getDeclaredConstructor((Class[]) null);
        System.out.println(cons);

        Car car = (Car) cons.newInstance();
        System.out.println(car);

        //通过实例化的对象和指定的方法名来获取方法
        Method setName = clazz.getDeclaredMethod("setName", String.class);
        Method setColor = clazz.getDeclaredMethod("setColor", String.class);
        System.out.println(setName);
        //反射方法将值写入对象
        setName.invoke(car, "audi");
        setColor.invoke(car, "red");

        car.printCar();

    }

    private static void testCarReflect()
            throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ClassLoader load = Thread.currentThread().getContextClassLoader();
        Class clazz = load.loadClass("com.Car");

        Car car = (Car) clazz.newInstance();
        System.out.println(car);
        car.price = "Hello";
        car.setColor("red");
        car.setName("audi");

        car.printCar();

    }
}
