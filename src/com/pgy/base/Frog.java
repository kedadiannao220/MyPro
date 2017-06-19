package com.pgy.base;

/**
 * 多态Demo
 * super代表父类，super.dispose代表执行父类的dispose方法
 * @author admin
 * @version $Id: Frog.java, v 0.1 2015年8月31日 上午9:09:34 admin Exp $
 */
class Characteristic {
    private String s;

    Characteristic(String s) {
        this.s = s;
        System.out.println("Creating Characteristic " + s);
    }

    protected void dispose() {
        System.out.println("disposing Characteristic " + s);
    }
}

class Description {
    private String s;

    Description(String s) {
        this.s = s;
        System.out.println("Creating Description " + s);
    }

    protected void dispose() {
        System.out.println("disposing Description " + s);
    }
}

class LivingCreature {
    private Characteristic p = new Characteristic("LivingCreaturee");
    private Description    t = new Description("LivingCreature");

    LivingCreature() {
        System.out.println("LivingCreature");
    }

    protected void dispose() {
        System.out.println("LivingCreature dispose");
        t.dispose();
        p.dispose();
    }
}

class Animal extends LivingCreature {
    private Characteristic p = new Characteristic("Animal");
    private Description    t = new Description("Animal");

    Animal() {
        System.out.println("Animal" + this);
    }

    protected void dispose() {
        System.out.println("Animal dispose");
        t.dispose();
        p.dispose();
        super.dispose();//super代表父类，调用父类的dispose方法

    }

}

public class Frog extends Animal {
    private Characteristic p = new Characteristic("Frog");
    private Description    t = new Description("Frog");

    Frog() {
        System.out.println("Frog");
    }

    protected void dispose() {
        System.out.println("Frog dispose");
        t.dispose();
        p.dispose();
        super.dispose();

    }

    public static void main(String[] args) {
        Frog f = new Frog();
        System.out.println("---------");
        f.dispose();
    }
}
