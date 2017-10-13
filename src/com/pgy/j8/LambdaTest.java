package com.pgy.j8;

import java.util.Arrays;
import java.util.function.*;
import java.util.stream.Collectors;

public class LambdaTest {
    public static void main(String[] args) {
        //        new Button().addActionListener(event -> System.out.println("clickIt"));
        //        new Button().addActionListener(event -> {
        //            System.out.println("clickIt");
        //            System.out.println("second word");
        //        });

        //        String[] array = { "hello", "world" };
        //
        //        Arrays.stream(array).forEach(s -> System.out.println(s));
        //        Arrays.stream(array).forEach(System.out::println);

        //        functionInterface();

        //        mapreducer();
        //
        //        mapcollect();

    }

    public static void functionInterface() {
        /**
         * Predicate<T> 入参T,返回boolean
         */
        Predicate<Integer> persi = x -> x > 6;
        System.out.println(persi.test(10));

        /**
         * BinaryOperator<T> 入参T,T，返回T
         */
        BinaryOperator<Integer> binaryOperator = (x, y) -> x + y;
        System.out.println(binaryOperator.apply(10, 2));

        /**
         * Consumer<T> 入参T，无返回void
         */
        Consumer<Integer> consumer = (x) -> System.out.println(x);
        consumer.accept(10);

        /**
         * Function<T,R> 入参T，返回R 
         */
        Function<Integer, String> function = x -> x + "10";
        System.out.println(function.apply(10));

        /**
         * UnaryOperator<T> 入参T 返回T
         */
        UnaryOperator<Integer> unaryOperator = (x) -> x + 10;
        System.out.println(unaryOperator.apply(10));

        /**
         * Supplier<T> 入参None，返回T
         */
        Supplier<Integer> supplier = () -> 10;
        System.out.println(supplier.get());
    }

    public static void add5() {
        Arrays.asList(1, 2, 3, 4, 5).stream().map((cost) -> 5 + cost).forEach(System.out::println);
    }

    public static void mapreducer() {
        System.out.println(Arrays.asList(1, 2, 3, 4, 5).stream().map(cost -> 5 + cost)
            .reduce(10, (sum, cost) -> sum + cost).toString());

        System.out
            .println(Arrays.asList(1).stream().reduce(10, (sum, cost) -> sum + cost).toString());

    }

    public static void mapcollect() {
        System.out.println(Arrays.asList("this", "is", "a", "chinese", "person").stream()
            .map(cost -> cost.toUpperCase()).collect(Collectors.joining(", ")));
        System.out.println(Arrays.asList("1", "2", "3", "4", "5", "0").stream()
            .map(cost -> 5 + cost).collect(Collectors.counting()));

    }

}
