package edu.macalester.comp124.breakout;

import comp124graphics.GraphicsGroup;
import comp124graphics.GraphicsObject;

import java.awt.*;
import java.util.Random;

public class BrickManager extends GraphicsGroup {

    Random random = new Random();
    int numberOfBricks = 0;

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
                numberOfBricks++;
            }
        }

    }

    public int checkBrickCollision(Ball ball, int ballRadius) {
        //1=top
        //2=left side
        //3=right side
        //4=bottom
        //5=left top corner
        //6=right bottom corner
        //7=left bottom corner
        //8=right top corner

        GraphicsObject leftTopCorner = getElementAt(ball.getX(), ball.getY());
        GraphicsObject leftBottomCorner = getElementAt(ball.getX(), ball.getY() + 2*ballRadius);
        GraphicsObject rightTopCorner = getElementAt(ball.getX() + 2*ballRadius, ball.getY());
        GraphicsObject rightBottomCorner = getElementAt(ball.getX() + 2*ballRadius, ball.getY() + 2*ballRadius);

        if(leftTopCorner != null){
            if(rightTopCorner != null){
                remove(leftTopCorner);
                numberOfBricks--;
                return 1;
            }

            if(leftBottomCorner != null){
                remove(leftTopCorner);
                numberOfBricks--;
                return 2;
            }

            if(rightBottomCorner == null){
                remove(leftTopCorner);
                numberOfBricks--;
                return 5;
            }
        }

        if(rightBottomCorner != null){
            if(rightTopCorner != null){
                remove(rightBottomCorner);
                numberOfBricks--;
                return 3;
            }

            if(leftBottomCorner != null){
                remove(rightBottomCorner);
                numberOfBricks--;
                return 4;
            }

            if(leftTopCorner == null){
                remove(rightBottomCorner);
                numberOfBricks--;
                return 6;
            }
        }

        if(leftBottomCorner != null){
            remove(leftBottomCorner);
            numberOfBricks--;
            return 7;
        }

        if(rightTopCorner != null){
            remove(rightTopCorner);
            numberOfBricks--;
            return 8;
        }

        return 0;
    }

    public int getNumberOfBricks(){
        return numberOfBricks;
    }

}
