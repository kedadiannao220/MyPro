package com.pgy.j8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * 常用接口实现
 */
public class ClassDocTest {
    public static void main(String[] args) {

        //        upperConvert();

        //        mapToFun();

        //        intStream();

        //        OptionalTest();

        streamToCollect();
    }

    public static void upperConvert() {

        long start = System.currentTimeMillis();
        List<Integer> sumList = new ArrayList<>();
        for (int i = 0; i <= 10000; i++) {
            sumList.add(i);
        }

        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();

        int[] ints = new int[sumList.size()];
        for (int i = 0; i < sumList.size(); i++) {
            ints[i] = sumList.get(i);
        }
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        sumList.stream().mapToInt(x -> x.intValue());
        System.out.println(System.currentTimeMillis() - start);

    }

    public static void mapToFun() {
        System.out.println(Stream.of(new Integer(20)).mapToInt(x -> x.intValue()).count());
        System.out.println(Stream.of(new Integer(20)).mapToLong(x -> x.longValue()).count());
        System.out.println(Stream.of(new Integer(20)).mapToDouble(x -> x.doubleValue()).count());
    }

    public static void intStream() {

        System.out.println(IntStream.of(1, 2, 3).average().getAsDouble());
        System.out.println(IntStream.of(1, 2, 3).max().getAsInt());
        System.out.println(IntStream.of(1, 2, 3).min().getAsInt());
        System.out.println(IntStream.of(1, 2, 3).findFirst().getAsInt());
        System.out.println(IntStream.of(1, 2, 3).findAny().getAsInt());
        System.out.println(IntStream.of(1, 2, 3).count());
        System.out.println(IntStream.of(1, 2, 3).sum());
        System.out.println(IntStream.of(1, 2, 3).limit(2).findFirst().getAsInt());
        IntStream.range(1, 10).forEach(x -> System.out.println(x));

    }

    public static void OptionalTest() {
        System.out.println(Optional.of("ab").get());
        //        System.out.println(Optional.of(null).get());//NPE
        System.out.println(Optional.ofNullable(null).orElse("bb"));
        System.out.println(Optional.empty().orElse("bb"));
        System.out.println(Optional.of("aa").orElse("bb"));
    }

    public static void streamToCollect() {
        System.out.println(Stream.of(1, 2, 3).collect(Collectors.toSet()));

        /**
         * toMap
         * {a_key=a_value, b_key=b_value, c_key=c_value}
         */
        System.out.println(
            Stream.of("a", "b", "c").collect(Collectors.toMap(s -> s + "_key", s -> s + "_value")));
        /**
         * groupingBy  返回Map
         * {a=2, b=1}
         */
        System.out
            .println(Stream.of("a", "a", "b").collect(groupingBy(x -> x, Collectors.counting())));

        System.out.println(Stream.of(1, 2, 3).collect(averagingInt(x -> x)));

        /**
         * partitioningBy 将数据分为两块，根据条件返回Map<Boolean,List>  
         */
        System.out.println(Stream.of(1, 2, 3).collect(partitioningBy(x -> x > 2)).get(true));

        /**
         * joining
         * a,b,c
         * [a,b,c]
         */
        System.out.println(Stream.of("a", "b", "c").collect(joining(",")));
        System.out.println(Stream.of("a", "b", "c").collect(joining(",", "[", "]")));

    }
}
