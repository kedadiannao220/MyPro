package com.pgy.strategyPattern;

public class FlyWithRocksImpl implements FlyBehavior {

    @Override public void fly() {
        System.out.println("The duck fly with Rocks");
    }

}
