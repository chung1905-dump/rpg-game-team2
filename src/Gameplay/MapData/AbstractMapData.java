package Gameplay.MapData;

import java.awt.Color;

public abstract class AbstractMapData {
    protected int width = 10;
    protected int height = 10;
    protected String name;
    protected int id;
    protected int[][] data;
    protected Color backgroundColor;
    protected int blockIds[];

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int[][] getData() {
        return data;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }
}
