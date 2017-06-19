package com.pgy.socket.basic;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * Created by admin on 03/06/2017.
 */
public class SocketChannelTest {
    public static void main(String[] args) throws IOException {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("120.25.192.95", 22);
        System.out.println(inetSocketAddress.isUnresolved());//若地址解析不成功,则返回true

        /**
         * socketChannel测试
         */
        SocketChannel socketChannel = SocketChannel.open(inetSocketAddress);
        System.out.println(socketChannel.isConnected());
        System.out.println(socketChannel.isOpen());
    }
}
