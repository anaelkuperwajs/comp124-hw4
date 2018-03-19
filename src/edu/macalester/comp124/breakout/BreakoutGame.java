package edu.macalester.comp124.breakout;


import comp124graphics.CanvasWindow;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Main program for the breakout game.
 *
 */
public class BreakoutGame extends CanvasWindow implements MouseListener {

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

    private final int BRICKMANAGER_X_POSITION = 0;
    private final int BRICKMANAGER_Y_POSITION = 100;

    boolean clicked = false;

    public BreakoutGame() {
        super("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
    }

    public void runOneGame(){

    }

    public void run(){
        resetGame();
        this.addMouseListener(this);
        while (!clicked){
            this.pause(1);
        }
        while(clicked){
            pause(10);
            ball.updatePosition();
        }
    }

    public void resetGame(){
        removeAll();

        brickManager = new BrickManager(BRICKMANAGER_X_POSITION, BRICKMANAGER_Y_POSITION);
        ball = new Ball(BALL_INITIAL_X_POSITION, BALL_INITIAL_Y_POSITION, BALL_RADIUS*2, BALL_RADIUS*2);
        bar = new Bar(BAR_INITIAL_X_POSITION, BAR_INITIAL_Y_POSITION, BAR_LENGTH, BAR_WIDTH);

        add(ball);
        add(bar);
        add(brickManager);
    }

    public static void main(String[] args){
        BreakoutGame prog = new BreakoutGame();
        prog.run();
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
}
