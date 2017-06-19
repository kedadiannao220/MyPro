package com.pgy.command;

public class CommandTest {
    public static void main(String[] args) {
        CommandController cc = new CommandController();

        cc.setCommand(new LightCommandImpl(new Light()));
        cc.execute();
    }
}
