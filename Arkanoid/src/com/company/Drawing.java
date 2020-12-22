package com.company;

import java.awt.*;
import java.util.ArrayList;

public class Drawing {

    public static void drawBackground(Graphics graphics, int screenWidth, int screenHeight) {
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, screenWidth, screenHeight);

        graphics.setColor(Color.lightGray);
        graphics.fillRect(0, screenHeight, screenWidth, 20);
    }

    public static void drawMenuText(Graphics graphics, int screenWidth, int screenHeight, int score, int maxScore) {
        graphics.setColor(Color.black);
        graphics.setFont(new Font("TimesRoman", Font.BOLD, 14));

        graphics.drawString("Score: " + score + "/" + maxScore, 10, screenHeight + 14);
        graphics.drawString("Follow Ball: F", screenWidth/4 - 25, screenHeight + 14);
        graphics.drawString("Win: W", screenWidth/2 - 25, screenHeight + 14);
        graphics.drawString("Pause: P", screenWidth - screenWidth/4 - 40, screenHeight + 14);
        graphics.drawString("Reset: R", screenWidth - 70, screenHeight + 14);
    }

    public static void drawPaddle(Graphics graphics, Paddle paddle) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight());
    }

    public static void drawBall(Graphics graphics, Ball ball) {
        graphics.setColor(Color.green);
        graphics.fillOval(ball.getX(), ball.getY(), ball.getDiameter(), ball.getDiameter());
    }

    public static void drawBlocks(Graphics graphics, ArrayList<Block> blocks) {
        graphics.setColor(Color.yellow);
        for (Block b : blocks) {
            graphics.fillRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());
        }
    }

}
