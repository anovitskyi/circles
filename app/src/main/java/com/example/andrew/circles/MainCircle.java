package com.example.andrew.circles;

import android.graphics.Color;

public class MainCircle extends Circle
{

    private static final int DEFAULT_RADIUS = 50;
    private static final int DEFAULT_SPEED = 30;
    private static final int MAIN_COLOR = Color.BLUE;

    public MainCircle(int x, int y)
    {
        super(x, y, DEFAULT_RADIUS);
        setColor(MAIN_COLOR);
    }

    public void changePosition(int x, int y)
    {
        int dx = (x - this.x) * DEFAULT_SPEED / CanvasView.width;
        int dy = (y - this.y) * DEFAULT_SPEED / CanvasView.height;
        this.x += dx;
        this.y += dy;
    }

    public void resetRadius()
    {
        x = CanvasView.width / 2;
        y = CanvasView.height / 2;
        radius = DEFAULT_RADIUS;
    }

    public void increase()
    {
        int percent = radius / 100 * 10;
        radius += percent;
    }
}
