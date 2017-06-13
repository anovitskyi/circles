package com.example.andrew.circles;


import android.graphics.Color;

import java.util.Random;

public class EnemyCircle extends Circle
{
    private static final int ENEMY_COLOR = Color.RED;
    private static final int FOOD_COLOR = Color.GREEN;
    private static final int DEFAULT_SPEED = 5;
    private int dx;
    private int dy;

    public EnemyCircle(int x, int y, int radius, int dx, int dy)
    {
        super(x, y, radius);
        this.dx = dx;
        this.dy = dy;
    }

    public static EnemyCircle getRandomCircle()
    {
        Random random = new Random();
        EnemyCircle circle;
        int width = random.nextInt(CanvasView.width);
        int height = random.nextInt(CanvasView.height);
        int rad = 10 + random.nextInt(100);
        int d_x = random.nextInt(DEFAULT_SPEED) + 1;
        int d_y = random.nextInt(DEFAULT_SPEED) + 1;
        circle = new EnemyCircle(width, height, rad, d_x, d_y);
        circle.setColor(ENEMY_COLOR);


        return circle;
    }

    public void changeColorDependsOn(Circle circle)
    {
        if (radius > circle.getRadius())
            setColor(ENEMY_COLOR);
        else
            setColor(FOOD_COLOR);
    }

    public void move()
    {
        x += dx;
        if (x >= CanvasView.width || x <= 0)
            dx *= -1;
        y += dy;
        if (y >= CanvasView.height || y <= 0)
            dy *= -1;
    }
}
