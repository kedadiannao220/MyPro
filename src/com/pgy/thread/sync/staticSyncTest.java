package com.pgy.thread.sync;

/**
 * Created by admin on 10/05/2017.
 */
public class staticSyncTest {

    public static void main(String[] args) {
        ThreadA tha = new ThreadA();
        tha.setName("tha");
        tha.start();

        ThreadB thb = new ThreadB();
        thb.setName("thb");
        thb.start();

        ThreadC thc = new ThreadC(new Service());
        thc.setName("thc");
        thc.start();
    }
}

class Service {
    synchronized public static void printA() {
        System.out.println(Thread.currentThread().getName() + "进入printA()");
        try {
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "离开printA()");
    }

    synchronized public static void printB() {
        System.out.println(Thread.currentThread().getName() + "进入printB()");
        System.out.println(Thread.currentThread().getName() + "离开printB()");
    }

    synchronized public void printC() {
        System.out.println(Thread.currentThread().getName() + "进入printC()");
        System.out.println(Thread.currentThread().getName() + "离开printC()");
    }

    /**
     * 为什么printC已经添加了synchronized,还是会异步执行
     * tha进入printA()
     * thc进入printC()
     * thc离开printC()
     * tha离开printA()
     * thb进入printB()
     * thb离开printB()
     */

}

class ThreadA extends Thread {

    @Override
    public void run() {
        super.run();
        Service.printA();
    }
}

class ThreadB extends Thread {

    @Override
    public void run() {
        super.run();
        Service.printB();
    }
}

class ThreadC extends Thread {
    private Service service;

    public ThreadC(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.printC();
    }
}