package com.pgy.mq;

/**
 * Created by admin on 01/08/2017.
 */
public class TestConsumer {

    public static void main(String[] args) {

        Consumer consumer = new Consumer();
        consumer.init();

        TestConsumer testMProducter = new TestConsumer();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(testMProducter.new ConsumerMq(consumer)).start();
        new Thread(testMProducter.new ConsumerMq(consumer)).start();
        new Thread(testMProducter.new ConsumerMq(consumer)).start();
        new Thread(testMProducter.new ConsumerMq(consumer)).start();
        new Thread(testMProducter.new ConsumerMq(consumer)).start();

    }

    private class ConsumerMq implements Runnable {
        Consumer consumer;

        public ConsumerMq(Consumer cosum) {
            this.consumer = cosum;
        }

        @Override
        public void run() {
            while (true) {
                consumer.getMessage("pengganyu");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
