package com.pgy.mq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by admin on 25/07/2017.
 */
public class Producter {

    private static String            USER_NAME   = ActiveMQConnection.DEFAULT_USER;

    private static String            PASSWORD    = ActiveMQConnection.DEFAULT_PASSWORD;

    private static String            BROKEN_URL  = ActiveMQConnection.DEFAULT_BROKER_URL;

    static AtomicInteger             count       = new AtomicInteger(0);

    static ActiveMQConnectionFactory connectionFactory;

    static Connection                connection;

    static Session                   session;

    static ThreadLocal<MessageProducer>     threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        init();
        sendMessage("hello");
    }

    public static void init() {

        try {
            connectionFactory = new ActiveMQConnectionFactory(USER_NAME, PASSWORD, BROKEN_URL);
            connection = connectionFactory.createConnection();

            connection.start();

            session = connection.createSession(true, Session.SESSION_TRANSACTED);
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

    public static void sendMessage(String disName) {
        try {
            Queue queue = session.createQueue(disName);

            MessageProducer messageProducer = null;

            if (threadLocal.get() != null) {
                messageProducer = threadLocal.get();
            } else {
                messageProducer = session.createProducer(queue);

                threadLocal.set(messageProducer);
            }

            while (true) {
                Thread.sleep(10000);

                int sum = count.getAndIncrement();

                TextMessage textMessage = session.createTextMessage(
                    Thread.currentThread().getName() + "helloWorld, times = " + sum);

                messageProducer.send(textMessage);

                session.commit();
            }

        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
