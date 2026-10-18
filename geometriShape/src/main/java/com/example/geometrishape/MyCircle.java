package com.example.geometrishape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyCircle extends GeometricShape {
    private static final double SPEED = 2;
    private static final double STEP = Math.PI / 60; // uhol otočenia za jeden krok
    private double angle = 0;

    public MyCircle(double x, double y) {
        super(x, y, 40, 40, Color.RED);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(x, y, width, height);
    }

    @Override
    public void move(double maxWidth, double maxHeight) {
        x += SPEED * Math.cos(angle);
        y += SPEED * Math.sin(angle);
        angle += STEP;
        KeepIn(maxWidth, maxHeight);
    }
}