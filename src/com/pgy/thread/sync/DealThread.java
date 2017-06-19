package com.pgy.thread.sync;

/**
 * Created by admin on 10/05/2017.
 */
public class DealThread {
    public static void main(String[] args) throws InterruptedException {

        ThreadTmp t1 = new ThreadTmp();
        t1.setFlag("a");

        Thread thread = new Thread(t1);
        thread.start();
        Thread.sleep(300000);

        t1.setFlag("b");
        Thread t2 = new Thread(t1);
        t2.start();

    }
}

class ThreadTmp implements Runnable {
    public String user;
    public Object lock1 = new Object();
    public Object lock2 = new Object();

    public void setFlag(String user) {
        this.user = user;
    }

    @Override
    public void run() {
        if (user.equals("a")) {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + "---" + user);

                try {
                    Thread.sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock2) {
                    System.out.println("lock2 is locked");
                }

            }
        }

        if (user.equals("b")) {
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + "----" + user);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock1) {
                    System.out.println("lock1 is locked");
                }
            }
        }
    }
}
