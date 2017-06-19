package com.pgy.api;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class jsonToString {
    public static void main(String[] args) {

    }

    /**
     * 将字符串首字母大写
     * @param str
     * @return
     */
    private static String transform(String str) {
        if (str == null || str.length() < 1) {
            return "";
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    /**
     * 将POJO对象转换成JSON格式的字符串 
     * @param obj
     * @return
     */
    public static String pojo2Json(Object obj) {
        if (obj == null) {
            return "";
        }
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder buff = new StringBuilder();
        buff.append("{");
        for (Field f : fields) {
            try {
                String methodName = "get" + transform(f.getName());
                Object value = clazz.getDeclaredMethod(methodName).invoke(obj, null);
                buff.append("\"");
                buff.append(f.getName());
                buff.append("\":");
                if (value == null) {
                    buff.append("\"\",");
                    continue;
                }
                if (value instanceof Boolean) {
                    buff.append((Boolean) value);
                    buff.append(",");
                } else if (value instanceof Number) {
                    buff.append((Number) value);
                    buff.append(",");
                } else if (value instanceof Date) {
                    buff.append("\"");
                    buff.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Date) value));
                    buff.append("\",");
                } else {
                    buff.append("\"");
                    buff.append(value.toString());
                    buff.append("\",");
                }
            } catch (SecurityException e) {
                //e.printStackTrace();  
            } catch (NoSuchMethodException e) {
                //e.printStackTrace();  
            } catch (IllegalArgumentException e) {
                //e.printStackTrace();  
            } catch (IllegalAccessException e) {
                //e.printStackTrace();  
            } catch (InvocationTargetException e) {
                //e.printStackTrace();  
            }

        }
        if (buff.length() > 1) {
            buff = buff.deleteCharAt(buff.length() - 1);
        }
        buff.append("}");
        return buff.toString();
    }
}
