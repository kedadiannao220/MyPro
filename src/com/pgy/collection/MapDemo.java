package com.pgy.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapDemo {
    public static void main(String[] args) {
        MapTest();
    }

    private static void MapTest() {
        Random ran = new Random(20);

        Map<Integer, Integer> intMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < 10; i++) {
            int key = ran.nextInt(20);
            Integer value = intMap.get(key) == null ? 1 : intMap.get(key) + 1;
            intMap.put(key, value);
        }

        System.out.println(intMap);
        System.out.println(intMap.keySet());
        System.out.println(intMap.containsValue(4231));
        System.out.println(intMap.containsKey(15));

    }
}
