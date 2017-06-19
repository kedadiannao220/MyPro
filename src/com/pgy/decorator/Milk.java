package com.pgy.decorator;

public class Milk extends CondimentDecorator {

    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    public int coast() {
        return beverage.coast() + BeverageUtil.milkPrice();
    }

    public String getDescription() {
        return "Milk" + beverage.getDescription();
    }

    public String sendGift() {
        return "100元代金劵";
    }
}
