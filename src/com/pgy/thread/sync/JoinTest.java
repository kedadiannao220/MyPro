package com.pgy.thread.sync;

/**
 * join可以使当前线程阻塞，直到运行结束后才执行下面的逻辑代码
 * Created by admin on 12/05/2017.
 */
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadJoin threadJoin = new ThreadJoin();
        threadJoin.setName("threadJoin");
        threadJoin.start();
        threadJoin.join();
        System.out.println("i want to echo this ");

    }
}

class ThreadJoin extends Thread {
    int value = 0;

    @Override
    public void run() {

        value = (int) Math.random() * 1000;
        System.out.println(" the value is " + value);
        try {
            Thread.sleep(value);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
