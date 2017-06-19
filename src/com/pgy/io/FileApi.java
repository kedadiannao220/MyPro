package com.pgy.io;

import java.io.*;

public class FileApi {

    /** 文件读取结束标志  */
    private static final int EOF = -1;

    /** 默认读取空间大小 */
    private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

    public static void main(String[] args) {

        String deleteFilePath = "/Users/admin/logs/aa/";
        String createFilePath = "/Users/admin/logs/aa/bb/cc/test.txt";
        String targetFilePath = "/Users/admin/logs/aa/bb/cc/";
        String sourceDirPath = "/Users/admin/logs/aa/bb/dd/";
        File createFile = new File(createFilePath);
        File DeleteFile = new File(deleteFilePath);
        File targetFile = new File(targetFilePath);
        File sourceFile = new File(sourceDirPath);

        System.out.println(DeleteFile.getPath());

        //        createFile(createFile);
        //
        //        copyFile(targetFile, sourceFile);
        //
        //        mvFile(createFile, targetFile);
        //        deleteFile(DeleteFile);

        //        System.out.println(getFileContent(targetFile, "utf-8"));

    }

    /**
     * 获取file当中的内容，为string类型
     * @param file file对象
     * @param charset 字符串编码
     * @return
     */
    public static final String getFileContent(File file, String charset) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            Reader reader = new InputStreamReader(fis, charset);
            StringWriter sw = new StringWriter();
            parseReaderToWrite(reader, sw);
            return sw.toString();
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * File.rename方法只支持同级目录下的重命名
     * 先拷贝文件，然后再删除源文件
     * @param sourceFile
     * @param targetFile
     */
    public static final void mvFile(File sourceFile, File targetFile) {
        copyFile(sourceFile, targetFile);
        deleteFile(sourceFile);
    }

    /**
     * 用FileInputStream与FileOutputStream方式进行对文件的读写操作，完成copy
     * 也可以通过FileReader与FileWirte进行实现
     * @param sourceFile
     * @param targetFile
     */
    public static final void copyFile(File sourceFile, File targetFile) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        if (!targetFile.exists()) {
            createFile(targetFile);
        }
        try {
            File[] fileList = sourceFile.listFiles();
            for (File file : fileList) {

                File newTargetFile = null;

                if (file.isFile()) {
                    fis = new FileInputStream(file);
                    newTargetFile = new File(targetFile, file.getName());
                    fos = new FileOutputStream(newTargetFile);
                    parseInputStreamToOutputStream(fis, fos);
                    fis.close();
                    fos.close();
                }
                if (file.isDirectory()) {
                    File oldFile = new File(sourceFile, file.getName());
                    File newFile = new File(targetFile, file.getName());
                    copyFile(oldFile, newFile);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 将inputStream转换为OutputStream
     * @param input
     * @param output
     * @return
     * @throws IOException
     */
    public static long parseInputStreamToOutputStream(InputStream input, OutputStream output)
            throws IOException {
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        long count = 0;
        int n = 0;
        while (EOF != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }

    /**
     * 将reader转换为write
     * @param input
     * @param output
     * @return
     * @throws IOException
     */
    public static long parseReaderToWrite(Reader input, Writer output) throws IOException {
        char[] buffer = new char[DEFAULT_BUFFER_SIZE];
        long count = 0;
        int n = 0;
        while (EOF != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }

    /**
     * 删除文件
     * File.delete不支持目录不为空的删除
     * 判断file对象列表当中的目录进行循环删除
     * @param file
     */
    public static final void deleteFile(File file) {

        if (file.exists()) {
            file.delete();
        }

        if (file.isDirectory()) {
            File[] fileList = file.listFiles();
            for (File fileChild : fileList) {
                deleteFile(fileChild);
            }
        }
    }

    /**
     * File对象createFile方法，不支持目录不存在的文件创建
     * 对其parent进行判断，若不存在，则对目录先进行递归创建
     *
     * @param filePath
     */
    public static final void createFile(File file) {

        File fileDir = file.getParentFile();
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        if (!file.getName().contains(".") && !file.exists()) {
            file.mkdir();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 合并字符串为目录
     * 由于不同的操作系统当中对于目录的层级分割是不一样的，例如：windows:\  其它的：/
     * 在拼接目录的时候我们不能单纯的使用/或\来进行拼接
     * @param parent
     * @param child
     * @return
     */
    public static final File spliceFile(String parent, String child) {
        return new File(parent, child);
    }

    public static void fileInfoPrint(File file) throws IOException {
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getCanonicalPath());
        System.out.println(file.getUsableSpace());
        System.out.println(file.getTotalSpace());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getParentFile());
        System.out.println(file.getPath());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.isHidden());
        System.out.println(file.isAbsolute());
        System.out.println(file.length());
        System.out.println(file.exists());
        System.out.println(file.hashCode());
        System.out.println(file.toString());
        System.out.println(file.toPath());
        System.out.println(file.toURI());

        file.setExecutable(true, false);
        file.setReadable(true);
        file.setWritable(true);
        file.setReadOnly();
    }

}
