package com.example.andrew.circles;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class CanvasView extends View implements Viewable
{
    public static int width;
    public static int height;
    private GameManager manager;
    private Paint paint;
    private Canvas canvas;


    public CanvasView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        initWidthAndHeight(context);
        manager = new GameManager(this);
        initPaint();
    }

    private void initWidthAndHeight(Context context)
    {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        width = point.x;
        height = point.y;
    }

    private void initPaint()
    {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }


    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        this.canvas = canvas;
        drawCircle(manager.getCircle());
        for (int i = 0; i < manager.getEnemies().size(); i++)
        {
            drawCircle(manager.getEnemies().get(i));
        }
    }

    @Override
    public void drawCircle(Circle circle)
    {
        paint.setColor(circle.getColor());
        canvas.drawCircle(circle.getX(), circle.getY(), circle.getRadius(), paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
       if (event.getAction() == MotionEvent.ACTION_MOVE)
       {
           manager.moveToPosition((int) event.getX(), (int) event.getY());
           invalidate();
       }
       return true;
    }

    @Override
    public void reset()
    {
        drawCircle(manager.getCircle());
        for (int i = 0; i < manager.getEnemies().size(); i++)
        {
            drawCircle(manager.getEnemies().get(i));
        }
    }
}
