package com.pgy.thread.sync;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 测试线程间通信--字节流
 * Created by admin on 12/05/2017.
 */
public class PipedStreamTest {

    public static void main(String[] args) throws IOException, InterruptedException {

        PipedDataTest pipedDataTest = new PipedDataTest();

        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();

        pipedInputStream.connect(pipedOutputStream);

        PipedThreadRead pipedThreadRead = new PipedThreadRead(pipedInputStream, pipedDataTest);
        PipedThreadWrite pipedThreadWrite = new PipedThreadWrite(pipedOutputStream, pipedDataTest);

        pipedThreadWrite.start();
        pipedThreadRead.start();



    }
}

class PipedThreadRead extends Thread {
    private PipedInputStream pipedInputStream;
    private PipedDataTest    pipedDataTest;

    public PipedThreadRead(PipedInputStream pipedInputStream, PipedDataTest pipedDataTest) {
        this.pipedInputStream = pipedInputStream;
        this.pipedDataTest = pipedDataTest;
    }

    @Override
    public void run() {
        super.run();
        PipedDataTest.readData(pipedInputStream);
    }
}

class PipedThreadWrite extends Thread {
    private PipedOutputStream pipedOutputStream;
    private PipedDataTest     pipedDataTest;

    public PipedThreadWrite(PipedOutputStream pipedOutputStream, PipedDataTest pipedDataTest) {
        this.pipedOutputStream = pipedOutputStream;
        this.pipedDataTest = pipedDataTest;
    }

    @Override
    public void run() {
        super.run();
        PipedDataTest.writeData(pipedOutputStream);
    }
}

class PipedDataTest {

    public static void writeData(PipedOutputStream pipedOutputStream) {
        try {
            System.out.println("start write");
            for (int i = 0; i < 1000; i++) {
                String data = i + "";
                pipedOutputStream.write(data.getBytes());
            }

            System.out.println();
            pipedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readData(PipedInputStream pipedInputStream) {
        try {
            System.out.println("start read");
            byte[] bytes = new byte[20];
            int readLen = pipedInputStream.read(bytes);

            while (readLen > 0) {
                String newData = new String(bytes, 0, readLen);
                System.out.print(newData);
                readLen = pipedInputStream.read(bytes);
            }
            System.out.println();

            pipedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
