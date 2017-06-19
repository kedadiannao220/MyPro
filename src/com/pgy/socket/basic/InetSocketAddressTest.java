package com.pgy.socket.basic;

import java.net.InetSocketAddress;

/**
 * Created by admin on 03/06/2017.
 */
public class InetSocketAddressTest {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("120.25.192.95", 22);
        System.out.println(inetSocketAddress.isUnresolved());//若地址解析不成功,则返回true
    }
}
