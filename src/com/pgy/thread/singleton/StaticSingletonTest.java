package com.pgy.thread.singleton;

/**
 * Created by admin on 19/05/2017.
 */
public class StaticSingletonTest {
    public static StaticSingletonTest str = null;

    static {
        str = new StaticSingletonTest();
    }

    public static StaticSingletonTest getInstance() {
        return str;
    }

    public static void main(String[] args) throws InterruptedException {
        StaticSingeltonThread staticSingeltonThread = new StaticSingeltonThread();
        System.out.println("实例化后的thread状态" + staticSingeltonThread.getState());
        staticSingeltonThread.start();
        Thread.sleep(100);
        System.out.println("run方法后的thread状态" + staticSingeltonThread.getState());
    }

}

class StaticSingeltonThread extends Thread {

    public StaticSingeltonThread() {
        System.out.println("thread的构造方法:" + Thread.currentThread().getState());
    }

    @Override
    public void run() {

        System.out.println("thread的run方法" + Thread.currentThread().getState());
        for (int i = 0; i < 10; i++) {
            System.out.println(StaticSingletonTest.getInstance().hashCode());
        }
    }
}
