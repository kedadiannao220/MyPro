package com.pgy.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * 当weakHashMap当中的元素没有指向和其他地方使用的时候，将会被垃圾回收掉
 * a标记为null，但在hashMap当中被使用，a不会被回收
 * a标记为null，不在hashMap当中被使用，则WeakHashMap当中的值会被回收
 * @author admin
 * @version $Id: WeakHashMapDemo.java, v 0.1 2015年10月2日 上午9:38:04 admin Exp $
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {
        //        WeakHashMapDemo1();
    }

    private static void WeakHashMapDemo1() {
        String a = new String("a");
        String b = new String("b");

        Map hashMap = new HashMap();

        hashMap.put(a, "hashA");
        hashMap.put(b, "hashB");

        Map weakMap = new WeakHashMap();

        weakMap.put(a, "weakA");
        weakMap.put(b, "weakB");

        hashMap.remove(a);

        a = null;
        b = null;

        System.gc();

        System.out.println(a);
        System.out.println(b);
        System.out.println(hashMap);
        System.out.println(weakMap);

        Iterator i = hashMap.entrySet().iterator();

        while (i.hasNext()) {
            System.out.println(i.next());
        }

        Iterator j = weakMap.entrySet().iterator();

        while (j.hasNext()) {
            System.out.println(j.next());
        }

    }
}
