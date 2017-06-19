package com.pgy.base;

import java.util.EnumMap;
import java.util.EnumSet;

public class EnumMethod {
    public static void main(String[] args) {
        //        enumToMap();
        //        enumToSet();
        testValueOf();
        testValueOfClass();
    }

    public static void enumToSet() {
        EnumSet<WeekEnum> weekEnumSet = EnumSet.allOf(WeekEnum.class);

        for (WeekEnum weekEnum : weekEnumSet) {
            System.out.println(weekEnum);
            System.out.println("name=" + weekEnum.name() + ",code=" + weekEnum.getCode());
        }

    }

    public static void enumToMap() {
        EnumMap<WeekEnum, String> enumMap = new EnumMap<WeekEnum, String>(WeekEnum.class);
        enumMap.put(WeekEnum.Monday, "周一");
        enumMap.put(WeekEnum.Tuseday, "周二");
        enumMap.put(WeekEnum.Wednesday, "周三");

        for (WeekEnum weekEnum : enumMap.keySet()) {
            System.out.println("key=" + weekEnum.name() + ",value=" + enumMap.get(weekEnum));
        }
    }

    public static void testValueOf() {
        System.out.println(WeekEnum.valueOf("5").getCode());
    }

    public static void testValueOfClass() {
        System.out.println(WeekEnum.valueOf(WeekEnum.class, "Friday").getCode());
    }
}
