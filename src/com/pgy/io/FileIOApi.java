package com.pgy.io;

import java.io.*;

public class FileIOApi {
    public static void main(String[] args) {
        File fileA = new File("/Users/admin/projects/emacs/config/aa");
        File fileB = new File("/Users/admin/projects/emacs/config/bb");
        File fileC = new File("/Users/admin/projects/emacs/config/cc");
        tetsInputStreamReader(fileA);
        testIOStream(fileA, fileB);
        testFileRW(fileA, fileC);
    }

    private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

    private static final int EOF = -1;

    public static void testIOStream(File fileA, File fileB) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        byte[] bt = new byte[(int) fileA.length()];
        try {
            fis = new FileInputStream(fileA);
            fis.read(bt);
            fileB.delete();
            fileB.createNewFile();
            fos = new FileOutputStream(fileB);
            fos.write(bt);
            //            fis.close();
            //            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testFileRW(File fileA, File fileC) {
        FileReader fr = null;
        FileWriter fw = null;
        char[] chr = new char[(int) fileA.length()];
        try {
            fr = new FileReader(fileA);
            fr.read(chr);
            fileC.delete();
            fileC.createNewFile();
            fw = new FileWriter(fileC);
            fw.write(chr);
            fr.close();
            fw.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void tetsInputStreamReader(File file) {
        InputStream is = null;
        InputStreamReader isr = null;
        try {
            is = new FileInputStream(file);
            System.out.println(is.read());
            isr = new InputStreamReader(is);
            System.out.println(isr.getEncoding());
            System.out.println(isr.ready());
            isr.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void testFileFilter(File file) {
    }

    public static long copyLarge(InputStream input, OutputStream output, byte[] buffer)
            throws IOException {
        long count = 0;
        int n = 0;
        while (EOF != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }

    public static long copyLarge(Reader input, Writer output, char[] buffer) throws IOException {
        long count = 0;
        int n = 0;
        while (EOF != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }

    public static Reader parseInputStreamToReader(InputStream input) {
        return new InputStreamReader(input);
    }

    public static Writer parseOutputStreamToWrite(OutputStream out) {
        return new OutputStreamWriter(out);
    }
}
