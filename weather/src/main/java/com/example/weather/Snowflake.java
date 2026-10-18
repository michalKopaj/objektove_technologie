package com.example.weather;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Snowflake extends WeatherObject {

    private final double speed = 1 + Math.random();
    private double phase = Math.random() * Math.PI * 2;

    public Snowflake(double x, double y) {
        super(new Circle(4, Color.WHITE), x, y);
    }

    @Override
    public void move(double width, double height) {
        node.setLayoutY(node.getLayoutY() + speed);
        node.setLayoutX(node.getLayoutX() + Math.sin(phase) * 0.8);
        phase += 0.08;
    }

    @Override
    public boolean isOutside(double width, double height) {
        return node.getLayoutY() > height
                || node.getLayoutX() < 0
                || node.getLayoutX() > width;
    }
}