package com.example.weather;

import javafx.scene.Node;

public abstract class WeatherObject {

    protected final Node node;

    protected WeatherObject(Node node, double x, double y) {
        this.node = node;
        node.setLayoutX(x);
        node.setLayoutY(y);
    }

    public Node getNode() {
        return node;
    }

    public abstract void move(double width, double height);

    public boolean isOutside(double width, double height) {
        return false;

    }
        public void moveLeft(double dx) {
            node.setLayoutX(node.getLayoutX() - dx);
        }
    }