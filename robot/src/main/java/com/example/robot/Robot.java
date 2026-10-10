package com.example.robot;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Robot extends Canvas{
    private GraphicsContext gc;
    private int smer=1;
    private int rychlost=5;
    private boolean auto=false;
    private Timeline timeline;

    public Robot(double x,double y){
        super(40,40);
        setLayoutX(x);
        setLayoutY(y);
        gc=getGraphicsContext2D();
        vykresli();
    }

}
