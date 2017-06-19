package com.pgy.decorator;

public class DarkRoast extends Beverage {

    public String getDescription() {
        return "DarkRoast";
    }

    int coast() {
        return BeverageUtil.darkRoastPrice();
    }

}
