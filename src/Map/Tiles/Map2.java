package Map.Tiles;

import Map.AbstractMap;

import java.awt.*;

public class Map2 extends AbstractMap {
    //define col x row
    private final int numCols = 10;
    private final int numRows = 10;

    //background color
    private final Color backgroundColor = new Color(166, 226, 107);
    private final int NUM_TILES = 3;
    private final int GRASS_TILE = 0;
    private final int WATER_TILE = 1;
    private final int TREE_TILE = 2;
    //contains array of integer 0, 2, 3
    private int rawMapData[][];
    //tiles are used in map
    private AbstractTile tiles[];
    private int tileWidth;
    private int tileHeight;

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {

    }

    @Override
    public void next() {

    }

    @Override
    public int[][] getRawMapData() {
        return rawMapData;
    }

    @Override
    public int[] getDefaultPosition() {
        return new int[0];
    }

    @Override
    public int getTileWidth() {
        return 0;
    }

    @Override
    public int getTileHeight() {
        return 0;
    }
}
