package com.example.andrew.circles;


import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class GameManager
{
    private static final int MAX_CIRCLES = 9;
    private MainCircle circle;
    private Viewable canvasView;
    private List<EnemyCircle> enemies;

    public GameManager(Viewable canvasView)
    {
        this.canvasView = canvasView;
        this.circle = new MainCircle(CanvasView.width / 2, CanvasView.height / 2);
        initEnemiesCircles();
    }

    private void initEnemiesCircles()
    {
        enemies = new ArrayList<>(10);

        enemies.add(EnemyCircle.getRandomCircle());
        for (int i = 0; i < MAX_CIRCLES; i++)
        {
            if (Double.compare(Math.random(), 0.5) == 1)
            {
                Circle area = new Circle(circle.x, circle.y, circle.radius * 3);
                EnemyCircle c;
                do
                {
                    c = EnemyCircle.getRandomCircle();
                }
                while (c.intersect(area));
                enemies.add(c);
            }
        }
        changeColors();
    }

    private void changeColors()
    {
        for (EnemyCircle enemy : enemies)
        {
            enemy.changeColorDependsOn(circle);
        }
    }

    public MainCircle getCircle()
    {
        return circle;
    }

    public void moveToPosition(int x, int y)
    {
        Circle circleToDelete = null;
        circle.changePosition(x, y);
        for (EnemyCircle enemy : enemies)
        {
            if (enemy.intersect(circle))
            {
                if (enemy.getColor() == Color.RED)
                    stopGame();
                else
                {
                    circleToDelete = enemy;
                    circle.increase();
                    changeColors();
                }
            }
        }
        if (circleToDelete != null)
            enemies.remove(circleToDelete);
        if (isNotEnd() == false)
            stopGame();
        for (EnemyCircle enemy : enemies)
        {
            enemy.move();
        }
    }

    private boolean isNotEnd()
    {
        boolean flag = false;
        for (EnemyCircle enemy : enemies)
        {
            if (enemy.getColor() == Color.GREEN)
                flag = true;
        }
        return flag;
    }

    private void stopGame()
    {
        circle.resetRadius();
        initEnemiesCircles();
        canvasView.reset();
    }

    public List<EnemyCircle> getEnemies()
    {
        return enemies;
    }
}
