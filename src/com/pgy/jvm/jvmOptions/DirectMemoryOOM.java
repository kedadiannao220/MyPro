package com.pgy.jvm.jvmOptions;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 本地内存溢出测试
 * Created by admin on 19/06/2017.
 */
public class DirectMemoryOOM {
    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafe = Unsafe.class.getDeclaredFields()[0];

        unsafe.setAccessible(true);

        Unsafe unsafe1 = (Unsafe) unsafe.get(null);

        unsafe1.allocateMemory(_1M);

    }
}
