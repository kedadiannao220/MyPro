package com.pgy.reflect;

import java.lang.reflect.Field;

public class FieldDemo {

    public static void main(String[] args)
            throws ClassNotFoundException, IllegalAccessException, RuntimeException {
        fieldTest();
    }

    private static void fieldTest()
            throws ClassNotFoundException, IllegalAccessException, RuntimeException {
        Class cl = Class.forName("com.ReflectDemo");
        Class superCl = cl.getSuperclass();

        Field[] fieldList = cl.getFields();
        fieldApiTest(fieldList[0]);
    }

    private static void fieldApiTest(Field field) throws RuntimeException, IllegalAccessException {
        System.out.println(field.getName());//获取属性name
        System.out.println(field.getModifiers());
        System.out.println(field.get(field.getName()));
        System.out.println(field.getAnnotations());
        System.out.println(field.getDeclaredAnnotations());
        System.out.println(field.getGenericType());
        System.out.println(field.getType());
        System.out.println(field.toGenericString());
        System.out.println(field.toString());
        field.set(field.getName(), "changeClassName");//不支持final属性，修改属性值
        System.out.println(field.get(field.getName()));//获取属性值
    }
}
