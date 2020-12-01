package com.andersenlab.katokoleg.servlets.controller.command;

public enum CommandType {
    SIGN_IN_COMMAND("login_command");

    private final String name;

    CommandType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
