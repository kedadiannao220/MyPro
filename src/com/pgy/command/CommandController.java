package com.pgy.command;

public class CommandController {
    Command cm;

    public CommandController() {
    }

    ;

    public void setCommand(Command cm) {
        this.cm = cm;
    }

    public void execute() {
        cm.execute();
    }
}
