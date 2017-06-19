package com.pgy.socket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketServerTest {
    public static void main(String[] args) throws UnknownHostException {
        SocketServer();
    }

    public static void SocketServer() throws UnknownHostException {
        System.out.println("this is server");
        InetAddress address = InetAddress.getByName("192.168.1.102");
        int port = 8081;
        try {
            // ServerSocket的构造方法当中可以传入limit及服务器端的address
            ServerSocket server = new ServerSocket(8081, 1, address);

            // 也可以指定一个端口号，默认address为localhost
            //            ServerSocket server = new ServerSocket(port);
            Socket socket = server.accept();//  server启动一下socket，可以让client接入

            //  从client读取入参
            Reader reader = new InputStreamReader(socket.getInputStream());

            char[] bytes = new char[64];
            int len;
            StringBuilder builder = new StringBuilder();
            if ((len = reader.read(bytes)) != -1) {
                builder.append(new String(bytes, 0, len));
            }

            System.out.println("form client" + builder.toString());

            reader.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
