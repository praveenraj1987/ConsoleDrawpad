package com.company.drawpad.command;

import com.company.drawpad.Canvas;

public class Quit implements Command {
    @Override
    public void executeOn(Canvas canvas) {
        canvas.quit();
    }
}