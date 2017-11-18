package Entity;

abstract public class AbstractCharacter {
    protected int facing;

    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int RIGHT = 2;
    public static final int LEFT = 3;

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

    abstract public void die();
}