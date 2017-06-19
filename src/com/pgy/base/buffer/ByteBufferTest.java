package com.pgy.base.buffer;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ByteBufferTest {
    public static void main(String[] args) {
        testByteBuffer();
    }

    public static void testByteBuffer() {

        File file = new File("/tmp/fileChannel.txt");

        RandomAccessFile accessFile;
        try {
            accessFile = new RandomAccessFile(file, "rw");
            FileChannel fileChannel = accessFile.getChannel();

            System.out.println(fileChannel.isOpen());
            System.out.println(fileChannel.position());
            System.out.println(fileChannel.size());

            ByteBuffer buffer = ByteBuffer.allocate(20);

            int buffread = fileChannel.read(buffer);

            while (buffread != -1) {
                buffer.flip();

                while (buffer.hasRemaining()) {
                    System.out.println(buffer.position());
                    System.out.println(buffer.limit());
                    System.out.println(buffer.capacity());
                    System.out.print((char) buffer.get());
                }

                buffer.clear();
                buffread = fileChannel.read(buffer);

            }

            accessFile.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
