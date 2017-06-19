package com.pgy.socket.basic;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by admin on 03/06/2017.
 */
public class SocketTest {
    public static void main(String[] args) throws IOException {
        testSocker();
        //        testGetAllInetAddress();
    }

    public static void testSocker() throws IOException {
        Socket socket = new Socket("120.25.192.95", 22);

        System.out.println(socket.isConnected());//校验是否连接
        System.out.println(socket.isClosed());//校验是否被关闭
        System.out.println(socket.getInetAddress());//获取服务器IP信息
        System.out.println(socket.getInputStream());//获取输入流
        System.out.println(socket.getLocalPort());//获取本地端口
        System.out.println(socket.isInputShutdown());//校验输入流是否被关闭
        System.out.println(socket.isOutputShutdown());//校验输出流是否被关闭
    }
}
