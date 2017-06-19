package com.pgy.socket;

import java.io.IOException;
import java.net.*;
import java.util.Enumeration;

public class SocketTest {
    public static void main(String[] args) throws IOException {
        testGetAllInetAddress();
    }

    public static void testGetAllInetAddress() {
        try {
            Enumeration<NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();

            while (interfaceList.hasMoreElements()) {
                System.out.println("--------------分割线-------------");

                NetworkInterface iface = interfaceList.nextElement();

                System.out.println("interface:" + iface.getName());
                System.out.println("interfaceHardwareAddress:" + iface.getHardwareAddress());

                for (InterfaceAddress address : iface.getInterfaceAddresses()) {
                    System.out.println("InterfaceAddress:" + address.getAddress());
                }

                Enumeration<InetAddress> addrList = iface.getInetAddresses();

                if (!addrList.hasMoreElements()) {
                    return;
                }

                while (addrList.hasMoreElements()) {
                    System.out.println("*******分割线*****");
                    InetAddress address = addrList.nextElement();
                    System.out.println("HostAddress" + address.getHostAddress());
                    System.out.println(address.getHostName());
                }

            }

        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
