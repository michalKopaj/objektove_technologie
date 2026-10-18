package com.example.geometrishape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;

public abstract class GeometricShape {
    protected double x,y;
    protected double width,height;
    protected Color color;

    public GeometricShape(double x, double y, double width, double height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;

    }

    public abstract void draw(GraphicsContext gc);

    public abstract void move(double maxWidth, double maxHeight);

    public void moveDown(double dy) {
        y += dy;
    }
    protected  void KeepIn(double maxWidth, double maxHeight) {
        x = Math.max(0, Math.min(x, maxWidth-width));
        y = Math.max(0, Math.min(y, maxHeight-height));

    }
    public Color getColor() {
        return color;

    }
    public void setColor(Color color) {
        this.color = color;
    }
}
