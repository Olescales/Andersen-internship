package com.andersenlab.katokoleg.servlets.controller.command;

import java.util.HashMap;
import java.util.Map;

public class CommandStorage {

    private static Map<String, Command> commandMap = new HashMap<>();

    public static void registerCommand(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public static Command getCommand(String commandName) {
        return commandMap.get(commandName);
    }

}
