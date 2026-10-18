package com.example.animal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Carnivore extends Animal {
    public static final double OFFSET = 80, SIZE = 440;

    public Carnivore() {
        super(OFFSET, SIZE, 4);
    }

    @Override
    public void move() {
        s += dir * rychlost;
        updateXY();
    }

    @Override
    public void kreslit(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.fillPolygon(
                new double[]{x, x - 12, x + 12},
                new double[]{y - 12, y + 10, y + 10}, 3);
    }

    public void changeDirection() {   // len Carnivore
        dir = -dir;
    }
}