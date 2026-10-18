package com.example.geometrishape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MySquare extends GeometricShape {
    private double dy = 2;

    public MySquare(double x, double y) {
        super(x, y, 40, 40, Color.GREEN);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(x, y, width, height);
    }

    @Override
    public void move(double maxWidth, double maxHeight) {
        y += dy;
        if (y < 0 || y + height > maxHeight) {
            dy = -dy;
        }
        KeepIn(maxWidth, maxHeight);
    }
}