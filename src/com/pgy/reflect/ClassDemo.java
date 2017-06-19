package com.pgy.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class A {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return Long.toString(id);
    }

    static void outPrint() {
        System.out.println("outPrint Method");
    }
}

class B extends A {

}

public class ClassDemo<T> extends A {
    private Class<T> type;

    public ClassDemo(Class<T> type) {
        this.type = type;
    }

    public static void ClassTest() throws InstantiationException, IllegalAccessException {
        try {
            Class<?> aclass = Class.forName("com.pgy.oob.A");
            System.out.println(aclass);
            System.out.println(aclass.newInstance());
            System.out.println(aclass.getSimpleName());
            System.out.println(aclass.getPackage());
            System.out.println(aclass.getSuperclass());

            System.out.println("===============本类属性=====================");
            Field[] aclassField = aclass.getDeclaredFields();
            for (Field filed : aclassField) {
                System.out.println(filed.getType());//属性类型
                System.out.println(filed);
            }
            System.out.println("===============本类方法=====================");
            Method[] aclassMethod = aclass.getMethods();
            for (Method method : aclassMethod) {
                System.out.println(method);
            }
            System.out.println("===============构造方法=====================");
            Constructor<?>[] aclassCons = aclass.getConstructors();
            for (Constructor<?> cons : aclassCons) {
                System.out.println(cons);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public List<T> create(int nElements) throws InstantiationException, IllegalAccessException {

        List<T> result = new ArrayList<T>();

        for (int i = 0; i < nElements; i++) {
            result.add(type.newInstance());
        }
        return result;

    }

    public void classCasTest() {
        B b = new B();
        //类型转换
        //方法一：可以先定义一个需要转换的类的class，能过class.cast方法进行转换
        Class<A> Aclass = A.class;
        A c = Aclass.cast(b);
        //方法二：通过类型强制转换
        c = (A) b;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ClassTest();
        ClassDemo<A> Aclass = new ClassDemo<A>(A.class);
        System.out.println(Aclass.create(2));

    }
}
