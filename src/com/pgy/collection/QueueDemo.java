package com.pgy.collection;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.concurrent.SynchronousQueue;

/**
 * 先进先出（FIFO）
 * @author admin
 * @version $Id: QueueDemo.java, v 0.1 2015年9月22日 上午9:57:59 admin Exp $
 */
public class QueueDemo {
    public static void main(String[] args) {
        QueueTest();
        System.out.println("***********************");
        SynchronousQueueTest();
        System.out.println("***********************");
        DequeTest();
        System.out.println("***********************");
        PriorityQueueTest();
    }

    private static void QueueTest() {
        Queue<String> queueInt = new LinkedList<String>();

        Collections.addAll(queueInt, "x y d a M q v H b a".split(" "));

        System.out.println(queueInt.element());//获取队列当中的第一个无素,但不移除
        System.out.println(queueInt.peek());//获取队列当中的第一个无素,但不移除
        System.out.println(queueInt.poll());//获取并移除队列当中的第一个元素，并返回
        System.out.println(queueInt.remove());//移除队列当中的第一个元素，并返回
        System.out.println(queueInt.offer("YY"));//将元素插入队列

        Queue<String> emptyQueue = new LinkedList<String>();
        System.out.println(emptyQueue.poll());// 返回null
        System.out.println(emptyQueue.peek());// 返回null
        //        System.out.println(emptyQueue.element()); // 抛出异常 NoSuchElementException
        //        System.out.println(emptyQueue.remove());// 抛出异常 NoSuchElementException

    }

    public static void DequeTest() {
        Deque<String> deque = new LinkedList<>();
        Collections.addAll(deque, "x y d a M q v H b a".split(" "));
        deque.offerLast("M");//在队列头塞入元素
        deque.offerFirst("A");//在队列尾塞入元素

        deque.pop();//移除队列当中的第一个元素
        deque.push("Z");//将Z元素放在队列的第一个位置
        System.out.println(deque.peekFirst());//获取队列当中第一个元素
        System.out.println(deque.peekLast());//获取队列当中最后一个元素
    }

    public static void PriorityQueueTest() {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        Collections.addAll(priorityQueue, "x y d a M q v H b a".split(" "));
        priorityQueue.add("I");
        System.out.println(JSON.toJSONString(priorityQueue, true));
        System.out.println(priorityQueue.peek());

    }

    /**
     * 阻塞队列
     */
    private static void SynchronousQueueTest() {
        SynchronousQueue<String> syncQueue = new SynchronousQueue<String>();

        System.out.println(syncQueue);
    }

}
