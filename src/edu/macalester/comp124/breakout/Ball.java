package edu.macalester.comp124.breakout;

import comp124graphics.Ellipse;

import java.awt.*;

public class Ball extends Ellipse {

    private int DX = 5;
    private int DY = 5;

    /**
     * Constructor to create the ellipse object and initialize its instance variables.
     * The default creates an ellipse at position x,y with a bounding rectangle of width and height.
     * The ellipse is drawn with a 1 pixel black stroke outline by default.
     *
     * @param x      position
     * @param y      position
     * @param width  of the bounding rectangle
     * @param height of the bounding rectangle
     */
    public Ball(double x, double y, double width, double height) {
        super(x, y, width, height);
        setFilled(true);
        setFillColor(Color.BLACK);
    }

    public void updatePosition(){

        double newXPosition = getX() + DX;
        double newYPosition = getY() + DY;

        DX = checkXPosition(newXPosition);
        DY = checkYPosition(newYPosition);

        setPosition(newXPosition, newYPosition);

    }

    public int checkXPosition(double newXPosition) {
        if(newXPosition >= 800){
            return -5;
        }

        else if(newXPosition <= 0){
            return 5;
        }

        else{
            return DX;
        }

    }

    public int checkYPosition(double newYPosition){
        if(newYPosition >= 800){
            return -5;
        }

        else if(newYPosition <= 0){
            return 5;
        }

        else{
            return DY;
        }
    }


}
