package com.pgy.io;

import com.idcos.common.biz.BizCoreException;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.util.Set;

public class FileAttributeApi {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/admin/projects/emacs/aa.md");
        File file = path.toFile();
        systemOutFileAttributes(file);

        setFileGroup(file, "admin");//系统当中存在admin group
        setFileUser(file, "admin");//系统当中存在admin user
        setFilePermissions(file, "777");

        System.out.println("--------------------------");
        systemOutFileAttributes(file);

    }

    /**
     * 输出文件的属性信息
     * @param file
     * @throws IOException
     */
    public static void systemOutFileAttributes(File file) throws IOException {
        PosixFileAttributes fileAttributes = getPosixFileAttributes(file);
        System.out.println("文件大小：" + fileAttributes.size());
        System.out.println("文件属组：" + fileAttributes.group());
        System.out.println("文件属主：" + fileAttributes.owner());
        System.out.println("文件权限(Set数组)：" + fileAttributes.permissions());
        System.out.println(
                "文件权限(rwx格式)：" + PosixFilePermissions.toString(fileAttributes.permissions()));
        System.out.println(
                "文件权限(Num格式)：" + parsePosixFilePermissiontoNum(fileAttributes.permissions()));
        System.out.println("是否为目录" + fileAttributes.isDirectory());
        System.out.println("创建时间：" + fileAttributes.creationTime());
        System.out.println("最后修改时间：" + fileAttributes.lastModifiedTime());
    }

    /**
     * 获取文件系统信息
     * @param file
     * @return
     */
    public static FileSystem getFileSystem(File file) {
        return file.toPath().getFileSystem();
    }

    public static String getFilePermissionNumber(File file) {
        return parsePosixFilePermissiontoNum(getPosixFileAttributes(file).permissions());
    }

    public static String getFilePermissionRWX(File file) {
        return parsePosixFilePermissiontoRWX(getFilePermissionNumber(file));
    }

    public static UserPrincipalLookupService getUserPrincipalLookupService(File file) {
        return getFileSystem(file).getUserPrincipalLookupService();
    }

    public static GroupPrincipal getGroupPrincipal(File file, String groupName) {
        try {
            return getUserPrincipalLookupService(file).lookupPrincipalByGroupName(groupName);
        } catch (IOException e) {
            throw new BizCoreException("获取group名称：" + groupName + "异常", e);
        }
    }

    public static UserPrincipal getUserPrincipal(File file, String userName) {
        try {
            return getUserPrincipalLookupService(file).lookupPrincipalByName(userName);
        } catch (IOException e) {
            throw new BizCoreException("获取user名称：" + userName + "异常", e);
        }
    }

    public static PosixFileAttributeView getPosixFileAttributeView(File file) {
        return Files.getFileAttributeView(file.toPath(), PosixFileAttributeView.class);
    }

    public static PosixFileAttributes getPosixFileAttributes(File file) {
        try {
            return getPosixFileAttributeView(file).readAttributes();
        } catch (IOException e) {
            throw new BizCoreException("获取文件属性异常", e);
        }
    }

    /**
     * 修改文件用户组
     * @param file 文件
     * @param groupName 用户组名称
     * @throws IOException
     */
    public static void setFileGroup(File file, String groupName) {
        try {
            getPosixFileAttributeView(file).setGroup(getGroupPrincipal(file, groupName));
        } catch (IOException e) {
            throw new BizCoreException("写入文件group信息异常", e);
        }

    }

    /**
     * 修改文件用户
     * @param file 文件
     * @param userName 用户名称
     * @throws IOException
     */
    public static void setFileUser(File file, String userName) {
        try {
            getPosixFileAttributeView(file).setOwner(getUserPrincipal(file, userName));
        } catch (IOException e) {
            throw new BizCoreException("写入文件user信息异常", e);
        }
    }

    /**
     * 修改文件权限
     * @param file 文件 
     * @param posixFilePermissionNumber 数字类型的权限,如：777
     * @throws IOException
     */
    public static void setFilePermissions(File file, String posixFilePermissionNumber) {
        try {
            getPosixFileAttributeView(file).setPermissions(parsePosixFilePermissiontoSet(
                    parsePosixFilePermissiontoRWX(posixFilePermissionNumber)));
        } catch (IOException e) {
            throw new BizCoreException("写入文件权限信息异常", e);
        }
    }

    /**
     * 修改文件权限
     * @param file 文件
     * @param perms 文件权限数组
     * @throws IOException
     */
    public static void setFilePermissions(File file, Set<PosixFilePermission> perms) {
        try {
            getPosixFileAttributeView(file).setPermissions(perms);
        } catch (IOException e) {
            throw new BizCoreException("写入文件权限信息异常", e);
        }
    }

    /**
     * 将RWX类型的文件权限修改为Set
     * @param PosixFilePermission
     * @return
     */
    public static Set<PosixFilePermission> parsePosixFilePermissiontoSet(
            String PosixFilePermission) {
        return PosixFilePermissions.fromString(PosixFilePermission);
    }

    /**
     * 将String rwx类型的权限转换为String 数字类型
     * 如：rw-r----- 转换为 640
     * @param PosixFilePermission
     * @return
     */
    public static String parsePosixFilePermissiontoNum(Set<PosixFilePermission> set) {
        int user = 0;
        int group = 0;
        int other = 0;
        for (PosixFilePermission permission : set) {

            switch (permission) {

                case OWNER_READ:
                    user = user | 4;
                    break;
                case OWNER_WRITE:
                    user = user | 2;
                    break;
                case OWNER_EXECUTE:
                    user = user | 1;
                    break;
                case GROUP_READ:
                    group = group | 4;
                    break;
                case GROUP_WRITE:
                    group = group | 2;
                    break;
                case GROUP_EXECUTE:
                    group = group | 1;
                    break;
                case OTHERS_READ:
                    other = other | 4;
                    break;
                case OTHERS_WRITE:
                    other = other | 2;
                    break;
                case OTHERS_EXECUTE:
                    other = other | 1;
                    break;
            }
        }
        return "" + user + group + other;
    }

    /**
     *
     * 将String 数字类型的权限转换为String rwx类型
     * 如：640 转换为 rw-r----- 
     * @param PosixFilePermission
     * @return
     */
    public static String parsePosixFilePermissiontoRWX(String PosixFilePermission) {
        String returnString = "";
        char[] perStringArr = PosixFilePermission.toCharArray();
        for (char x : perStringArr) {
            if ((x & 4) == 4) {
                returnString += "r";
            } else {
                returnString += "-";
            }
            if ((x & 2) == 2) {
                returnString += "w";
            } else {
                returnString += "-";
            }
            if ((x & 1) == 1) {
                returnString += "x";
            } else {
                returnString += "-";
            }
        }

        return returnString;
    }
}
