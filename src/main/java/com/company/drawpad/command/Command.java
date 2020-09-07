package com.company.drawpad.command;

import com.company.drawpad.Canvas;

public interface Command {
    void executeOn(Canvas canvas);
}
