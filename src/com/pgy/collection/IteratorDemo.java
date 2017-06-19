package com.pgy.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * iterator容器，可以遍历全部的Collection容器
 * 只对于一切继承Collection的类进行操作，不能操作map，常用的list,set,Queue
 * @author admin
 * @version $Id: IteratorDemo.java, v 0.1 2015年9月21日 上午10:05:41 admin Exp $
 */
public class IteratorDemo {
    public static void main(String[] args) {
        IteratorTest();
    }

    private static void IteratorTest() {
        List<String> strList = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            strList.add(i + "");
        }

        Iterator<String> it = strList.iterator();

        while (it.hasNext()) {
            String type = it.next();
            if ("3".equals(type)) {
                it.remove();
            }
        }

    }
}
