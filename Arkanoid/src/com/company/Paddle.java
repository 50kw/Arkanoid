package com.company;

import java.awt.*;

public class Paddle {
    private static final int PADDLE_WIDTH = 80;
    private static final int PADDLE_HEIGHT = 20;
    private static final int PADDLE_VELOCITY = 10;

    private final Rectangle paddle;
    private boolean isMovingRight;
    private boolean isMovingLeft;
    
    public Paddle(int screenWidth, int screenHeight) {
        int x = screenWidth/2 - PADDLE_WIDTH/2;
        int y = screenHeight - screenHeight/10;
        this.paddle = new Rectangle(x , y, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

    public void move() {
        if (isMovingRight) {
            paddle.setLocation(getX() + PADDLE_VELOCITY, getY());
        } else if (isMovingLeft){
            paddle.setLocation(getX() - PADDLE_VELOCITY, getY());
        }
    }

    public Rectangle getPaddle() {return paddle; }

    public int getX() { return (int) paddle.getX(); }

    public void setX(int x) { paddle.setLocation(x, getY()); }

    public int getY() { return (int) paddle.getY(); }

    public int getWidth() { return (int) paddle.getWidth(); }

    public int getHeight() { return (int) paddle.getHeight(); }

    public void moveRight(boolean moveRight) { isMovingRight = moveRight; }

    public void moveLeft(boolean moveLeft) { isMovingLeft = moveLeft; }

}
