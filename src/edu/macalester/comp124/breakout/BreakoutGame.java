package edu.macalester.comp124.breakout;


import com.sun.xml.internal.bind.v2.TODO;
import comp124graphics.CanvasWindow;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Main program for the breakout game.
 *
 */
public class BreakoutGame extends CanvasWindow implements MouseListener, MouseMotionListener{

    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 800;

    Ball ball;
    Bar bar;
    BrickManager brickManager;

    private final int BAR_LENGTH = 100;
    private final int BAR_WIDTH = 10;
    private final int BAR_INITIAL_X_POSITION = 350;
    private final int BAR_INITIAL_Y_POSITION = 700;

    private final int BALL_RADIUS = 10;
    private final int BALL_INITIAL_X_POSITION = 390;
    private final int BALL_INITIAL_Y_POSITION = 680;
    private int DX = 5;
    private int DY = -5;

    private final int BRICKMANAGER_X_POSITION = 0;
    private final int BRICKMANAGER_Y_POSITION = 100;

    private boolean clicked = false;

    private double mouseXPosition = 0;

    public BreakoutGame() {
        super("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
    }

    //each life
    public void runOneGame(){
        while(ball.getY() < 800){
            pause(10);
            bar.barMove(mouseXPosition);
            updatePosition();
        }

        ball.setPosition(BALL_INITIAL_X_POSITION, BALL_INITIAL_Y_POSITION);
        DY = -5;
    }

    //runs one entire game, 3 lives
    public void run(){
        resetGame();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        waitForClick();
        runOneGame();
        waitForClick();
        runOneGame();
        waitForClick();
        runOneGame();

        if(brickManager.getNumberOfBricks() > 0){
            System.out.println("You lost :(");
        }

        else if(brickManager.getNumberOfBricks() == 0){
            System.out.println("You won!");
        }

        getWindowFrame().dispose();

    }

    public void waitForClick(){
        while(!clicked){
            this.pause(1);
        }

        clicked = false;
    }

    //sets up one entire game
    public void resetGame(){
        removeAll();

        brickManager = new BrickManager(BRICKMANAGER_X_POSITION, BRICKMANAGER_Y_POSITION);
        ball = new Ball(BALL_INITIAL_X_POSITION, BALL_INITIAL_Y_POSITION, BALL_RADIUS*2, BALL_RADIUS*2);
        bar = new Bar(BAR_INITIAL_X_POSITION, BAR_INITIAL_Y_POSITION, BAR_LENGTH, BAR_WIDTH);

        add(ball);
        add(bar);
        add(brickManager);
    }

    public void updatePosition(){
        //is this in the right order?

        double newXPosition = ball.getX() + DX;
        double newYPosition = ball.getY() + DY;

        DX = checkWallCollision(newXPosition, DX);
        DY = checkWallCollision(newYPosition, DY);
        int side = brickManager.checkBrickCollision(ball, BALL_RADIUS);
        DX = handleBrickCollision(side, DX);
        DY = handleBrickCollision(side, DY);
        DY = checkBarCollision(ball, DY);

        ball.setPosition(newXPosition, newYPosition);

    }

    //brick collision
    public int handleBrickCollision(int side, int speed){
        if(side == 1 || side == 4 || side == 5 || side == 6 || side == 7 || side == 8){
            return DY * -1;
        }

        else if(side == 2 || side == 3){
            return DX * -1;
        }

        else{
            return speed;
        }
    }

    //wall collisions
    public int checkWallCollision(double newPosition, int speed) {
        //checks right/bottom wall
        if(newPosition >= 800){
            return -5;
        }

        //checks left/top wall
        else if(newPosition <= 0){
            return 5;
        }

        else{
            return speed;
        }

    }

    //bar collision
    public int checkBarCollision(Ball ball, int speed){
        if(getElementAt(ball.getX(), ball.getY() + 2*BALL_RADIUS) instanceof Bar && getElementAt(ball.getX() + 2*BALL_RADIUS, ball.getY() + 2*BALL_RADIUS) instanceof Bar){

            ball.setPosition(ball.getX(), BAR_INITIAL_Y_POSITION); //is this working??
            return DY*-1;
        }

        else{
            return speed;
        }
    }



    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        clicked = true;
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    /**
     * Invoked when the mouse cursor has been moved onto a component
     * but no buttons have been pushed.
     *
     * @param e
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        mouseXPosition = e.getX();
    }

    public static void main(String[] args){
        BreakoutGame prog = new BreakoutGame();
        prog.run();
    }

}
