package com.pgy.base;

import java.util.ArrayList;
import java.util.List;

public enum WeekEnum {
    Monday(1, "周一"),

    Tuseday(2, "周二"),

    Wednesday(3, "周三"),

    Thursday(4, "周四"),

    Friday(5, "周五"),

    Saturday(6, "周六"),

    Sunday(7, "周七"),;

    private int    code;
    private String description;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public WeekEnum findOneByCode(int code) {
        for (WeekEnum demo : WeekEnum.values()) {
            if (demo.getCode() == code) {
                return demo;
            }
        }
        return null;
    }

    public List<Integer> allCode() {
        List<Integer> allCodes = new ArrayList<Integer>();
        for (WeekEnum demo : WeekEnum.values()) {
            allCodes.add(demo.getCode());
        }
        return allCodes;
    }

    private WeekEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

}
