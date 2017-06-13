package com.example.andrew.circles;


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

        enemies = new ArrayList<>(10);

        enemies.add(EnemyCircle.getRandomCircle());
        for (int i = 0; i < MAX_CIRCLES; i++)
        {
            if (Double.compare(Math.random(), 0.5) == 1)
                enemies.add(EnemyCircle.getRandomCircle());
        }
    }

    public MainCircle getCircle()
    {
        return circle;
    }

    public void moveToPosition(int x, int y)
    {
        circle.changePosition(x, y);
    }

    public List<EnemyCircle> getEnemies()
    {
        return enemies;
    }
}
