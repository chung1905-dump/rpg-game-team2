package Entity;

import Map.AbstractMap;

import java.awt.*;

abstract public class AbstractCharacter {
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int RIGHT = 2;
    public static final int LEFT = 3;
    protected int facing;
    protected int hp;
    protected AbstractMap map;

    protected Rectangle rectangle;

    protected int x;
    protected int y;

    public int getWidth() {
        return (int) rectangle.getWidth();
    }

    public int getHeight() {
        return (int) rectangle.getHeight();
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public int getX() {
        return getRectangle().x;
    }

    public int getY() {
        return getRectangle().y;
    }

    public int[] getGridXY() {
        return new int[]{(int) rectangle.getX() / map.getTileWidth(), (int) rectangle.getY() / map.getTileHeight()};
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