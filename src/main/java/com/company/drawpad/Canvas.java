package com.company.drawpad;

public class Canvas {
    int width, height;
    int[][] canvasArea;
    boolean canQuit;
    Console console;

    public Canvas(Console console) {
        this.console = console;
    }

    public Canvas() {
        this.console = new Console();
    }

    public boolean quitting() {
        return canQuit;
    }

    public void create(int width, int height) {
        this.width = width;
        this.height = height;
        canvasArea = new int[width + 2][height + 2];
        lineWithChar(0, 0, 0, height + 1, '|');
        lineWithChar(width + 1, 0, width + 1, height + 1, '|');
        lineWithChar(0, 0, width + 1, 0, '-');
        lineWithChar(0, height + 1, width + 1, height + 1, '-');
    }

    public void quit() {
        canQuit = true;
    }

    public void line(int x1, int y1, int x2, int y2) {
        if (x1 < 1 || x2 < 1 || y1 < 1 || y2 < 1) {
            console.println("Out Of Bounds coordinates");
            return;
        }
        if (x2 > width || x1 > width || y2 > height || y1 > height) {
            console.println("Out Of Bounds coordinates");
            return;
        }
        lineWithChar(x1, y1, x2, y2, 'x');
    }

    private void lineWithChar(int x1, int y1, int x2, int y2, int c) {
        if (x1 == x2) {
            if (y1 > y2) {
                int temp = y1;
                y1 = y2;
                y2 = temp;
            }
            for (int y = y1; y <= y2; y++) {
                canvasArea[x1][y] = c;
            }
        } else if (y1 == y2) {
            if (x1 > x2) {
                int temp = x1;
                x1 = x2;
                x2 = temp;
            }
            for (int x = x1; x <= x2; x++) {
                canvasArea[x][y1] = c;
            }
        } else {
            console.println("Slope lines not supported");
        }
    }

    public void rectangle(int x1, int y1, int x2, int y2) {
        line(x1, y1, x1, y2);
        line(x1, y1, x2, y1);
        line(x1, y2, x2, y2);
        line(x2, y1, x2, y2);
    }

    public void bucketFill(int x, int y, int c) {
        if (x < 1 || y < 1 || x > width || y > height) return;
        if (canvasArea[x][y] != 0) return;
        canvasArea[x][y] = c;
        bucketFill(x + 1, y, c);
        bucketFill(x, y + 1, c);
        bucketFill(x - 1, y, c);
        bucketFill(x, y - 1, c);
    }

    public void print(String msg) {
        console.println(msg);
    }

    public void display() {
        for (int y = 0; y < height + 2; y++) {
            for (int x = 0; x < width + 2; x++) {
                final char c = canvasArea[x][y] == 0 ? ' ' : (char) canvasArea[x][y];
                console.print(c);
            }
            console.println("");
        }
    }
}
