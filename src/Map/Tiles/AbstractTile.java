package Map.Tiles;

import java.awt.*;

import Entity.AbstractEntity;

abstract public class AbstractTile {
    //draw tile
    abstract public void draw(Graphics2D g, int x, int y, int w, int h);
}
