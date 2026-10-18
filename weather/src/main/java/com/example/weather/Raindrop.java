package com.example.weather;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Raindrop extends WeatherObject {

    private final double speed = 6 + Math.random() * 3;

    public Raindrop(double x, double y) {
        super(createShape(), x, y);
    }

    private static Line createShape() {
        Line line = new Line(0, 0, 0, 12);
        line.setStroke(Color.DEEPSKYBLUE);
        line.setStrokeWidth(2);
        return line;
    }

    @Override
    public void move(double width, double height) {
        node.setLayoutY(node.getLayoutY() + speed);
    }

    @Override
    public boolean isOutside(double width, double height) {
        return node.getLayoutY() > height
                || node.getLayoutX() < 0
                || node.getLayoutX() > width;
    }
}