package com.company;

import java.awt.*;

public class Block {

    private final Rectangle block;

    public Block(int x, int y, int width, int height) {
        this.block = new Rectangle(x, y, width, height);
    }

    public Rectangle getBlock() { return block; }

    public int getX() {
        return (int) block.getX();
    }

    public int getY() {
        return (int) block.getY();
    }

    public int getWidth() {
        return (int) block.getWidth();
    }

    public int getHeight() {
        return (int) block.getHeight();
    }

}
