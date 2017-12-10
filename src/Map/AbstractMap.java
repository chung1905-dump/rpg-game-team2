package Map;

import Entity.AbstractCharacter;

import java.awt.*;
import java.util.ArrayList;

abstract public class AbstractMap {
    //blocks
    protected ArrayList<Rectangle> blockRectangles;

    //portals
    protected Rectangle portalRectangle;

    //monsters
    protected ArrayList<AbstractCharacter> monsters;

    //update function
    abstract public void update();

    //draw map function
    abstract public void draw(Graphics2D g);

    //where player will appear
    abstract public int[] getDefaultPosition();

    //get tile size
    abstract public int getTileWidth();

    abstract public int getTileHeight();

    public ArrayList<AbstractCharacter> getMonsters() {
        return monsters;
    }

    protected void addBlock(Rectangle r) {
        blockRectangles.add(r);
    }

    public boolean isBlock(Rectangle r) {
        for (Rectangle a : blockRectangles) {
            if (a.intersects(r)) {
                return true;
            }
        }
        return false;
    }

    public void setPortalRectangle(Rectangle r) {
        portalRectangle = r;
    }

    public boolean isPortal(Rectangle r) {
        if (portalRectangle == null) {
            return false;
        }
        return portalRectangle.intersects(r);
    }

    abstract public AbstractMap next();

    abstract public int[][] getRawMapData();
}
