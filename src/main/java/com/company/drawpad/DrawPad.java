package com.company.drawpad;

import com.company.drawpad.command.Command;
import com.company.drawpad.command.executor.CommandExecutor;
import com.company.drawpad.command.parser.ConsoleCommandParser;

public class DrawPad {
    private ConsoleCommandParser commandParser;
    private Canvas canvas;
    private CommandExecutor commandExecutor;

    public DrawPad() {
        commandParser = new ConsoleCommandParser(new Console());
        canvas = new Canvas(new Console());
        commandExecutor = new CommandExecutor();
    }

    public void start() {
        do {
            Command command = commandParser.ReadCommand();
            commandExecutor.execute(command, canvas);
        }while(!canvas.quitting());
    }
}
