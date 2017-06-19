package com.pgy.collection;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author admin
 * @version $Id: ListIteratorDemo.java, v 0.1 2015年9月21日 上午10:23:03 admin Exp $
 */
public class ListIteratorDemo {
    public static void main(String[] args) {
        ListIteratorTest();

        System.out.println("CountingInteger test");

        System.out.println(new CountingInteger(10));
    }

    private static void ListIteratorTest() {
        List<String> strList = new ArrayList<String>();

        for (int i = 0; i < 3; i++) {
            strList.add(i + "");
        }

        ListIterator<String> it = strList.listIterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }

    }
}

class CountingInteger extends AbstractList<Integer> {

    private int size = 0;

    public CountingInteger(int size) {
        this.size = size < 0 ? 0 : size;
    }

    @Override public Integer get(int index) {
        return Integer.valueOf(index);
    }

    @Override public int size() {
        return size;
    }
}
