package com.company.drawpad.command;

import com.company.drawpad.Canvas;

public class Create implements Command {
    int xAxisLen, yAxisLen;

    public Create(int xAxis, int yAxis) {
        this.xAxisLen = xAxis;
        this.yAxisLen = yAxis;
    }

    @Override
    public void executeOn(Canvas canvas) {
        canvas.create(xAxisLen, yAxisLen);
        canvas.display();
    }
}
