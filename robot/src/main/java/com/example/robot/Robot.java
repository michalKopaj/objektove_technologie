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
        casovac=new Timeline(new KeyFrame(Duration.millis(50),e -> pusun()));
        casovac.setCycleCount(Timeline.INDEFINITE);
        setOnKeyPressed(evt ->spracuj(evt));
        setOnMouseClicked(evt -> klik());
        setFocusTraversable(true);
        requestFocus();
    }
    private void vykresli(){
            gc.clearRect(0,0,40,40);
            gc.setFill(Color.Blue);
            gc.fillRect(0,0,40,40);
            gc.setFill(Color.YELLOW);
            switch (smer){
                case 0: gc.fillRect(0,0,40,40); break;
                case 1: gc.fillRect(30,0,10,40);break;
                case 2: gc.fillRect(0,30,40,10);break;
                case 3: gc.fillRect(0,0,10,40);break;

                

            }




    }

}
