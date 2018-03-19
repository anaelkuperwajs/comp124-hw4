package edu.macalester.comp124.breakout;

import comp124graphics.GraphicsGroup;

import java.awt.*;
import java.util.Random;

public class BrickManager extends GraphicsGroup {

    Random random = new Random();

    public BrickManager(double x, double y){
        super(x, y);
        createBricks();
    }

    public void createBricks(){
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                Brick brick = new Brick(0, 0, 78, 18);
                brick.setFilled(true);
                brick.setFillColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                add(brick, j*80, i*20);
            }
        }

    }

}
