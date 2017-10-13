package com.pgy.lamba;

import java.util.Optional;

public class StreamTest {

    public static void main(String[] args) {
        String name = "";

        System.out.println(Optional.ofNullable(name).orElse("name"));
    }
}
