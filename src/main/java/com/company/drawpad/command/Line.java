package com.company.drawpad.command;

import com.company.drawpad.Canvas;


public class Line implements Command {
    public int x1;
    public int y1;
    public int x2;
    public int y2;

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void executeOn(Canvas canvas) {
        canvas.line(x1, y1, x2, y2);
        canvas.display();
    }
}
