package com.pgy.j8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {

        //运算结果为：1共计耗时：3
        outterLoop();
        //运算结果为：1共计耗时：106
        innerLoop();

        //        streamMethod();

        //        reduceTest();

        //        countChars();
        //        minStrLength();
    }

    public static void streamMethod() {
        /**
         * collect(toList)
         */
        List<String> collected = Stream.of("a", "b", "c", "d").collect(Collectors.toList());

        /**
         * map  Function<T,R>
         */
        Stream.of("a", "b", "c", "d").map(str -> str.toUpperCase()).collect(Collectors.toList());

        /**
         * filter  Predicate<T>
         */
        Stream.of("a", "b", "c", "d").filter(str -> str.equals("a")).collect(Collectors.toList());

        /**
         * flatMap
         */
        Stream.of(Arrays.asList("a", "b"), Arrays.asList("c", "d")).flatMap(str -> str.stream())
            .collect(Collectors.toList());

        /**
         * max and min
         */
        System.out.println(Stream.of(1, 2, 4).max(Comparator.comparing(x -> x)).get());
        System.out.println(Stream.of(1, 2, 4).min(Comparator.comparing(x -> x)).get());

    }

    public static void reduceTest() {
        /**
         * acc即为sum
         */
        System.out.println(Stream.of(1, 2, 3).reduce(0, (acc, el) -> acc + el));
    }

    public static void outterLoop() {
        int sum = 0;
        List<Integer> set = new ArrayList<>();
        for (int i = 0; i <= 10000; i++) {
            set.add(i);
        }

        long start = System.currentTimeMillis();

        for (int i : set) {
            if (i == 9999) {
                sum++;
            }
        }

        long end = System.currentTimeMillis() - start;

        System.out.println("运算结果为：" + sum + "共计耗时：" + end);
    }

    public static void innerLoop() {
        List<Integer> set = new ArrayList<>();
        for (int i = 0; i <= 10000; i++) {
            set.add(i);
        }

        long _start = System.currentTimeMillis();

        long count = set.stream().unordered().filter(x -> x == 9999).count();

        long _end = System.currentTimeMillis() - _start;

        System.out.println("运算结果为：" + count + "共计耗时：" + _end);

    }

    public static void countChars() {
        String str = "hello";

        System.out.println(str.chars().count());
    }

    public static void minStrLength() {
        System.out.println(Arrays.asList("hello", "newxfdsaf", "fdsfsdafd").stream()
            .min(Comparator.comparing(x -> x.chars().count())).get());
    }

}
