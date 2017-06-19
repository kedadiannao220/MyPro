package com.pgy.command;

public class LightCommandImpl implements Command {
    Light light;

    public LightCommandImpl(Light light) {
        this.light = light;
    }

    @Override public void execute() {
        light.on();
    }
}
