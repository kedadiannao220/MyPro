package com.pgy.strategyPattern;

public class RedHeadDuck extends Duck implements FlyBehavior {

    @Override public void display() {
        System.out.println("This is RedHeadDuck");
    }

    @Override public void fly() {
        System.out.println("fly behavior");
    }

}
