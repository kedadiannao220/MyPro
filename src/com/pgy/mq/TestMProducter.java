package com.pgy.mq;

/**
 * Created by admin on 25/07/2017.
 */
public class TestMProducter {

    public static void main(String[] args) {

        Producter producter = new Producter();
        producter.init();

        TestMProducter testMProducter = new TestMProducter();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(testMProducter.new ProducterMq(producter)).start();
        new Thread(testMProducter.new ProducterMq(producter)).start();
        new Thread(testMProducter.new ProducterMq(producter)).start();
        new Thread(testMProducter.new ProducterMq(producter)).start();
        new Thread(testMProducter.new ProducterMq(producter)).start();

    }

    private class ProducterMq implements Runnable {
        Producter producter;

        public ProducterMq(Producter producter) {
            this.producter = producter;
        }

        @Override
        public void run() {
            while (true) {
                producter.sendMessage("pengganyu");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
