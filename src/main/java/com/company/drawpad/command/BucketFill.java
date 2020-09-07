package com.company.drawpad.command;

import com.company.drawpad.Canvas;

public class BucketFill implements Command {
    int x, y, c;

    public BucketFill(int x, int y, int c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    @Override
    public void executeOn(Canvas canvas) {
        canvas.bucketFill(x,y,c);
        canvas.display();
    }
}
