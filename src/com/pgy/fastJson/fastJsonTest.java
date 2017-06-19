package com.pgy.fastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

public class fastJsonTest {
    public static void main(String[] args) {
        Student stu = new Student();

        stu.setAge("10");
        stu.setName("zhangsan");

        System.out.println(JSON.toJSON(stu));

    }
}

class Student {
    @JSONField(name = "年龄：", serialize = true, ordinal = 2) private String age;

    @JSONField(ordinal = 1) private String name;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}