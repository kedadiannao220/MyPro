package com.pgy.Ioc;

public class Car {
    public  String price;
    private String color;
    private String name;

    //①默认构造函数  
    public Car() {
    }

    //②带参构造函数  
    public Car(String name, String color, int maxSpeed) {
        this.name = name;
        this.color = color;
    }

    public void printCar() {
        System.out.println("price:" + price + ";carName:" + name + ";carColr:" + color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
