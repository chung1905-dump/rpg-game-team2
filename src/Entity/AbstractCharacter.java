package Entity;

import java.awt.*;

abstract public class AbstractCharacter {
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int RIGHT = 2;
    public static final int LEFT = 3;
    protected int facing;
    protected int hp;

    protected int width;
    protected int height;

    protected int currentX;
    protected int currentY;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return currentX;
    }

    public int getY() {
        return currentY;
    }

    public int getFacing() {
        return facing;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isDie() {
        return hp <= 0;
    }

    abstract public void update();

    abstract public void draw(Graphics2D g);
}