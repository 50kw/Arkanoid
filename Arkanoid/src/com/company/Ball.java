package com.company;

import java.awt.*;
import java.util.Random;

public class Ball {
    private static final int BALL_DIAMETER = 20;
    private int xVelocity;
    private int yVelocity;
    private final Rectangle ball;
    private boolean isMoving;


    public Ball(int x, int y) {
        ball = new Rectangle(x, y, BALL_DIAMETER, BALL_DIAMETER);
        this.xVelocity = getRandomOneOrMinusOne() * 5;
        this.yVelocity = -5;
    }

    public int getRandomOneOrMinusOne() {
        int rand = new Random().nextInt(10);
        if (rand < 5) {
            return -1;
        } else return 1;
    }

    public void move() {
        if (isMoving) {
            ball.setLocation(getX() + xVelocity, getY() + yVelocity);
        }
    }

    public Rectangle getBall() { return ball; }

    public int getX() {
        return (int) ball.getX();
    }

    public int getY() {
        return (int) ball.getY();
    }

    public int getDiameter() {
        return BALL_DIAMETER;
    }

    public void reverseXVel() {
        xVelocity = xVelocity * -1;
    }

    public void reverseYVel() {
        yVelocity = yVelocity * -1;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

}
