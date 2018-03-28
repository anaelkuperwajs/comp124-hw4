package edu.macalester.comp124.breakout;

import comp124graphics.Ellipse;

import java.awt.*;

public class Ball extends Ellipse {

    private int DX = 5;
    private int DY = -5;

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

    public void ballMove(){
        setPosition(getX() + DX, getY() + DY);
    }

    public int getDX(){
        return DX;
    }

    public int getDY(){
        return DY;
    }

    public void setDX(int DX){
        this.DX = DX;
    }

    public void setDY(int DY){
        this.DY = DY;
    }
}
