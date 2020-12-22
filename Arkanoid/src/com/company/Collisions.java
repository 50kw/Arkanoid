package com.company;

import java.util.List;

public class Collisions {

    private boolean gameOver = false;

    public void checkPaddleWallCollision(Paddle paddle) {
        if (paddle.getX() <= 0) {
            paddle.setX(0);
            paddle.moveLeft(false);
        } else if (paddle.getX() >= (GamePlay.SCREEN_WIDTH - paddle.getWidth())) {
            paddle.setX((GamePlay.SCREEN_WIDTH - paddle.getWidth()));
            paddle.moveRight(false);
        }
    }

    public void checkBallWallCollision(Ball ball) {
        if (ball.getX() <= 0) {
            ball.reverseXVel();
        } if (ball.getY() <= 0) {
            ball.reverseYVel();
        } if (ball.getX() + ball.getDiameter() >= GamePlay.SCREEN_WIDTH) {
            ball.reverseXVel();
        } if (ball.getY() + ball.getDiameter() >= GamePlay.SCREEN_HEIGHT) {
            gameOver = true;
        }
    }

    public void checkBallPaddleCollision(Ball ball, Paddle paddle) {
        if (paddle.getPaddle().intersects(ball.getBall())) {
            if ((ball.getY() >= paddle.getY())) {
                ball.reverseXVel();
            } else {
                ball.reverseYVel();
            }
        }
    }

    public void checkBallBlockCollision(List<Block> blocks, Ball ball) {
        for (Block block : blocks) {
            if (block.getBlock().intersects(ball.getBall())) {
                ball.reverseYVel();
                blocks.remove(block);
                break;
            }
        }
    }

    public void checkCollisions(Ball ball, Paddle paddle, List<Block> blocks) {
        checkPaddleWallCollision(paddle);
        checkBallWallCollision(ball);
        checkBallPaddleCollision(ball, paddle);
        checkBallBlockCollision(blocks, ball);
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
