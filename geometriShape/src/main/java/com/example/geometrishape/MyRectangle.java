package com.example.geometrishape;

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;


public class MyRectangle extends GeometricShape{
    private double dx=2;

    public MyRectangle(double x,double y){


            super(x,y,60,30, Color.ORANGE);
    }
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(x, y, width, height);
    }

    @Override
    public void move(double maxWidth, double maxHeight) {
        x += dx;
        if (x < 0 || x + width > maxWidth) {
            dx = -dx;
        }
        KeepIn(maxWidth, maxHeight);
    }
}
