package com.pgy.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class SocketClientTest {
    public static void main(String[] args) {
        SocketClient();
    }

    public static void SocketClient() {
        System.out.println("this is client");

        String inetAddress = "192.168.1.102";
        int port = 8081;

        try {
            Socket socketClient = new Socket(inetAddress, port);

            Writer writer = new OutputStreamWriter(socketClient.getOutputStream());

            writer.write("hello server");
            writer.flush();
            writer.close();
            socketClient.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
