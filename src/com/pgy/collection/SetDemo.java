package com.pgy.collection;

import java.util.*;

/**
 * set里面的元素不能重复
 * linkedSet与treeSet有自己的特点
 *
 * 问题： treeSet里面是如何实现排序的？
 * @author admin
 * @version $Id: SetDemo.java, v 0.1 2015年9月22日 上午9:23:50 admin Exp $
 */
public class SetDemo {
    public static void main(String[] args) {
        SetTest();
        LinkedHashSetTest();
        TreeSetTest();
    }

    /**
     *
     */
    private static void SetTest() {
        Set<String> setStr = new HashSet<String>();

        Collections.addAll(setStr, "x y d a M q v H b a".split(" "));

        System.out.println(setStr);
        System.out.println(setStr.hashCode());
        for (String s : setStr) {
            System.out.println(s.hashCode());
        }
    }

    /**
     * linkedHashSet记录元素的添加顺序
     */
    private static void LinkedHashSetTest() {
        Set<String> setLinked = new LinkedHashSet<String>();

        Collections.addAll(setLinked, "x y d a M q v H b a 中国".split(" "));

        System.out.println(setLinked);
    }

    /**
     * treeSet对元素进行排序后输出
     */
    private static void TreeSetTest() {
        Set<String> setTree = new TreeSet<String>();

        Collections.addAll(setTree, "x y d a M q v H b a 美国 中国".split(" "));

        System.out.println(setTree);
    }
}
