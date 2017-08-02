package com.pgy.mq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by admin on 25/07/2017.
 */
public class Consumer {
    private static String        USER_NAME   = ActiveMQConnection.DEFAULT_USER;

    private static String        PASSWORD    = ActiveMQConnection.DEFAULT_PASSWORD;

    private static String        BROKEN_URL  = ActiveMQConnection.DEFAULT_BROKER_URL;

    AtomicInteger                count       = new AtomicInteger(0);

    ActiveMQConnectionFactory    connectionFactory;

    Connection                   connection;

    Session                      session;

    ThreadLocal<MessageConsumer> threadLocal = new ThreadLocal();

    public void init() {
        try {
            connectionFactory = new ActiveMQConnectionFactory(USER_NAME, PASSWORD, BROKEN_URL);
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void getMessage(String disName) {
        Queue queue = null;
        try {
            queue = session.createQueue(disName);
            MessageConsumer messageConsumer = null;

            if (threadLocal.get() != null) {
                messageConsumer = threadLocal.get();
            } else {
                messageConsumer = session.createConsumer(queue);

                threadLocal.set(messageConsumer);
            }

            while (true) {
                Thread.sleep(1000);

                TextMessage textMessage = (TextMessage) messageConsumer.receive();

                if (textMessage != null) {
                    textMessage.acknowledge();

                    System.out.println(Thread.currentThread().getName() + "获取消息:"
                                       + textMessage.getText() + "-----" + count.getAndIncrement());
                } else {
                    break;
                }

            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
