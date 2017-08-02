package com.pgy.collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by admin on 02/08/2017.
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        ConcurrentThread concurrentThread1 = new ConcurrentThread(map);
        concurrentThread1.start();

        System.out.println("----- start concurrentThread1");

        ConcurrentThread concurrentThread2 = new ConcurrentThread(map);
        concurrentThread2.start();
        System.out.println("----- start concurrentThread2");

        ConcurrentThread concurrentThread3 = new ConcurrentThread(map);
        concurrentThread3.start();
        System.out.println("----- start concurrentThread3");

        ConcurrentThread concurrentThread4 = new ConcurrentThread(map);
        concurrentThread4.start();
        System.out.println("----- start concurrentThread4");

        ConcurrentThread concurrentThread5 = new ConcurrentThread(map);
        concurrentThread5.start();
        System.out.println("----- start concurrentThread5");

        ConcurrentThread concurrentThread6 = new ConcurrentThread(map);
        concurrentThread6.start();
        System.out.println("----- start concurrentThread6");

        ConcurrentThread concurrentThread7 = new ConcurrentThread(map);
        concurrentThread7.start();
        System.out.println("----- start concurrentThread7");

        System.out.println(map.values());
    }
}

class ConcurrentThread extends Thread {
    ConcurrentHashMap map;

    public ConcurrentThread(ConcurrentHashMap map) {
        this.map = map;
    }

    @Override
    public void run() {
        map.put(Thread.currentThread().getId(), Thread.currentThread().getName());
    }
}
