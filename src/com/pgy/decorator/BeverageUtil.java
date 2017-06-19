package com.pgy.decorator;

public class BeverageUtil {
    public static int milkPrice() {
        return 5;
    }

    public static int darkRoastPrice() {
        return 20;
    }

    public static Double discount(Beverage beverage) {
        System.out.println("原价" + beverage.coast());
        return beverage.coast() * 0.8;
    }
}
