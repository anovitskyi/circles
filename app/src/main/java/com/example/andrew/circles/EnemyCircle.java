package com.example.andrew.circles;


import android.graphics.Color;

import java.util.Random;

public class EnemyCircle extends Circle
{
    private static final int ENEMY_COLOR = Color.RED;

    public EnemyCircle(int x, int y, int radius)
    {
        super(x, y, radius);
    }

    public static EnemyCircle getRandomCircle()
    {
        Random random = new Random();
        EnemyCircle circle;
        int width = random.nextInt(CanvasView.width);
        int height = random.nextInt(CanvasView.height);
        int rad = 10 + random.nextInt(100);
        circle = new EnemyCircle(width, height, rad);
        circle.setColor(ENEMY_COLOR);
        return circle;
    }
}