package com.pgy.strategyPattern;

public class FlyWithWingsImpl implements FlyBehavior {

    @Override public void fly() {
        System.out.println("The duck fly with wings!");
    }

}
