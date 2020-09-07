package com.company.drawpad.command.parser;

import com.company.drawpad.Console;
import com.company.drawpad.command.Command;
import com.company.drawpad.command.builder.CommandBuilder;

import java.util.Arrays;

public class ConsoleCommandParser {

    private Console console;
    private CommandBuilder commandBuilder;

    public ConsoleCommandParser(Console console) {
        this.console = console;
        commandBuilder = new CommandBuilder();
    }

    public Command ReadCommand() {
        String commandString = ReadCommandString();
        return parseCommandString(commandString);
    }

    private Command parseCommandString(String commandString) {
        String[] commandArguments = commandString.split(" ");
        commandBuilder.addCommandType(commandArguments[0].charAt(0));
        commandBuilder.addParams(Arrays.copyOfRange(commandArguments, 1, commandArguments.length));
        return commandBuilder.build();
    }

    private String ReadCommandString() {
        console.print("enter command: ");
        return console.readLine();
    }
}
