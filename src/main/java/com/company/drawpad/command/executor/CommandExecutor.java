package com.company.drawpad.command.executor;

import com.company.drawpad.Canvas;
import com.company.drawpad.command.Command;

public class CommandExecutor {
    public void execute(Command command, Canvas canvas) {
        command.executeOn(canvas);
    }
}
