package com.example.weather;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Cloud extends com.example.weather.WeatherObject {

    private static final double SPEED = 0.4;

    public Cloud(double x, double y) {
        super(createShape(), x, y);
    }

    private static Group createShape() {
        Group g = new Group(
                new Circle(20, 25, 18),
                new Circle(45, 18, 22),
                new Circle(70, 25, 18),
                new Rectangle(20, 25, 50, 18));
        for (Node n : g.getChildren()) {
            ((Shape) n).setFill(Color.WHITE);
        }
        return g;
    }
    public void setColor(Color color) {
        for (Node n : ((Group) node).getChildren()) {
            ((Shape) n).setFill(color);
        }
    }

    @Override
    public void move(double width, double height) {
        node.setLayoutX(node.getLayoutX() + SPEED);
        double w = node.getLayoutBounds().getWidth();

        if (node.getLayoutX() > width) {
            node.setLayoutX(-w);
        } else if (node.getLayoutX() + w < 0) {
            node.setLayoutX(width);
        }
    }
}