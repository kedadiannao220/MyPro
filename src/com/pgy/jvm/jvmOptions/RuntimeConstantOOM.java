package com.pgy.jvm.jvmOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池内存溢出
 *
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * java.lang.OutOfMemoryError: PermGen space
 *
 * Created by admin on 19/06/2017.
 */
public class RuntimeConstantOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        int i = 0;

        while (true) {
            list.add(String.valueOf(i++).intern());
        }

    }
}
