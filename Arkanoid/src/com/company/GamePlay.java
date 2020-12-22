package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GamePlay extends JPanel implements Runnable, KeyListener {

    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;
    public static final int MENU_HEIGHT = 20;

    private int maxScore;
    private int score;

    private boolean followBall = false;

    private Paddle paddle;
    private Ball ball;
    private ArrayList<Block> blocks;
    private final Collisions collisions;

    public GamePlay() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT + MENU_HEIGHT));
        this.setFocusable(true);
        this.addKeyListener(this);

        reset();
        collisions = new Collisions();
        Thread thread = new Thread(this);
        thread.start();
    }

    public void reset() {
        newPaddle();
        newBall();
        newBlocks();

        maxScore = blocks.size();
        score = 0;
    }

    public void newPaddle() {
        paddle = new Paddle(SCREEN_WIDTH, SCREEN_HEIGHT);
    }

    public void newBall() {
        ball = new Ball((paddle.getX() + paddle.getWidth()/2 - 10), (paddle.getY() - 25));
    }

    public void newBlocks() {
        blocks = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 14; j++) {
                blocks.add(new Block(j*50, i*50,49,20));
            }
        }
    }

    public void paint(Graphics g) {
        Drawing.drawBackground(g, SCREEN_WIDTH, SCREEN_HEIGHT);
        Drawing.drawBall(g, ball);
        Drawing.drawPaddle(g, paddle);
        Drawing.drawBlocks(g, blocks);
        Drawing.drawMenuText(g, SCREEN_WIDTH, SCREEN_HEIGHT, score, maxScore);
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                collisions.checkCollisions(ball, paddle, blocks);
                gameStatus();
                move();
                repaint();
                delta--;
            }
        }
    }

    private void gameStatus() {
        score = maxScore - blocks.size();
        if (score == maxScore) {
            ball.setMoving(false);
        }
        if (collisions.isGameOver()) {
            reset();
            ball.setMoving(false);
            collisions.setGameOver(false);
        }
        if (followBall) {
            paddle.setX(ball.getX() - ball.getDiameter() -10);
        }
    }

    private void move() {
        paddle.move();
        ball.move();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            paddle.moveRight(true);
            ball.setMoving(true);
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            paddle.moveLeft(true);
            ball.setMoving(true);
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_P) {
            ball.setMoving(!ball.isMoving());
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_R) {
            reset();
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_F) {
            followBall = !followBall;
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_W) {
            blocks.clear();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            paddle.moveRight(false);
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            paddle.moveLeft(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {}
}
