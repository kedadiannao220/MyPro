package com.pgy.j8;

public class DefaultTest {

    public static void main(String[] args) {
        //        Parent pent = new ParentImpl();
        //        pent.welcome();

        //        Child child = new ChildImpl();
        //        child.welcome();

        //        Parent parent = new OverideParentImpl();
        //        parent.welcome();
        //    }

      new OverrideChildImpl().welcome();


    }

}

interface Parent {

    public default void welcome() {
        System.out.println("this is parent");
    }
}

class ParentImpl implements Parent {

}

class OverideParentImpl extends ParentImpl {
    @Override
    public void welcome() {
        System.out.println("this is OverrideParentImpl");
    }
}

interface Child extends Parent {

    default void welcome() {
        System.out.println("this is Child");
    }
}

class ChildImpl {
//    public void welcome() {
//        System.out.println("this is ChildImpl");
//    }
}

class OverrideChildImpl extends ChildImpl implements Parent {

}

interface Person {
    public default void welcome() {
        System.out.println("this is person");
    }
}

class MultiChild implements Person, Parent {

    @Override
    public void welcome() {
        System.out.println("this is MultiChild");
    }
}
