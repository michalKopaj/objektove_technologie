package com.example.animal;
import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Herbivore extends Animal {
    public static final double OFFSET = 20;
    public static final double SIZE = 560;

    public Herbivore() {
        super(OFFSET, SIZE, 2);
    }

    @Override
    public void move() {
        s += dir * rychlost;
        updateXY();
    }

    @Override
    public void kreslit(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.fillOval(x - 10, y - 10, 20, 20);
    }
}
