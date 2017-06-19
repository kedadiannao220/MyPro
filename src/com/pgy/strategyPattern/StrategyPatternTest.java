package com.pgy.strategyPattern;

/**
 * 设计原则：
 * 1. 多用组合，少用继承
 * 2. 针对接口编程，不根据实现编程
 * 3. 变化的部分与不变的部分分离
 * @author admin
 * @version $Id: StrategyPatternTest.java, v 0.1 2015年12月16日 下午1:06:30 admin Exp $
 */
public class StrategyPatternTest {
    public static void main(String[] args) {
        /**
         * new一个父类，让jvm去选择加载的子类实现
         */
        RedHeadDuck redDuck = new RedHeadDuck();
        redDuck.display();
        redDuck.fly();

        Duck BlackDuck = new BlackHeadDuck();
        BlackDuck.display();

    }
}
