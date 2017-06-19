package com.pgy.decorator;

public class Customer {
    public static void main(String[] args) {
        secondCode();
    }

    public static void secondCode() {
        Beverage coffee = new DarkRoast();
        coffee = new Milk(coffee);
        System.out.println("现价" + BeverageUtil.discount(coffee));
    }

    public static void myCode() {
        /**
         * 此种实现将价格放在外面，面向过程实现
         * 假如milk当中有千万个属性那需要声明千万个变更，然后再累加
         * 将所有的属性都放在Beverage当中内聚，实现所有的属性在new对象的时候就可以计算完成
         */
        int cost = 0;
        Beverage darkRoast = new DarkRoast();
        cost += darkRoast.coast();
        CondimentDecorator milk = new Milk(darkRoast);
        cost += milk.coast();
        System.out.println("i ordered " + milk.getDescription());
        System.out.println("i will pay " + cost);
        System.out.println("i have a gift about " + milk.sendGift());
    }
}
