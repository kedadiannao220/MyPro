package com.pgy.collection;

import java.util.Stack;

/**
 * 栈：先进后出LIFO
 * @author admin
 * @version $Id: StackDemo.java, v 0.1 2015年9月21日 上午10:26:31 admin Exp $
 */
public class StackDemo {
    public static void main(String[] args) {
        StackTest();
    }

    private static void StackTest() {
        Stack<String> strSta = new Stack<String>();
        for (int i = 0; i < 3; i++) {
            strSta.push(i + "");
        }

        System.out.println(strSta);
        System.out.println(strSta.peek());//查看栈的顶元素
        System.out.println(strSta.pop());//移除栈的顶元素，并返回
        System.out.println(strSta.firstElement());//栈底元素 
        System.out.println(strSta.lastElement());//栈顶元素
    }
}
