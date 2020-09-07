package com.company.drawpad.command;

import com.company.drawpad.Canvas;

public class NotSupported implements Command {
    @Override
    public void executeOn(Canvas canvas) {
        canvas.print("Command Not Supported");
    }
}