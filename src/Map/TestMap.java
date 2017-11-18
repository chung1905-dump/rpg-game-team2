package Map;

import Interface.Blockable;
import Main.GamePanel;
import Map.Tiles.*;
import Tool.Collision;

import java.awt.*;

public class TestMap extends AbstractMap {
    //define col x row
    private final int numCols = 10;
    private final int numRows = 10;

    private final Color backgroundColor = new Color(166,226,107);

    private int rawMapData[][];
    private AbstractTile tiles[];
    private int tileWidth;
    private int tileHeight;

    private final int NUM_TILES = 3;
    private final int GRASS_TILE = 0;
    private final int WATER_TILE = 1;
    private final int TREE_TILE = 2;


    public TestMap() {
        tiles = new AbstractTile[NUM_TILES];
        tiles[GRASS_TILE] = new Grass();
        tiles[WATER_TILE] = new Water();
        tiles[TREE_TILE] = new Tree();

        tileWidth = GamePanel.WIDTH / numCols;
        tileHeight = GamePanel.HEIGHT / numRows;
        //define map content
        rawMapData = new int[][]{
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 2, 0, 0, 0, 0, 0, 2, 2},
                {2, 0, 0, 1, 0, 0, 0, 0, 2, 2},
                {2, 0, 0, 1, 1, 0, 0, 0, 2, 2},
                {2, 0, 0, 1, 1, 0, 1, 0, 2, 2},
                {2, 0, 0, 1, 1, 0, 0, 0, 2, 2},
                {2, 0, 0, 1, 1, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        };

        for (int x = 0; x < numCols; x++) {
            for (int y = 0; y < numRows; y++) {
                if (tiles[rawMapData[y][x]] instanceof Blockable) {
                    Collision.addBlock(
                            (Blockable) tiles[rawMapData[y][x]],
                            new Rectangle(x * tileWidth, y * tileHeight, tileWidth, tileHeight)
                    );
                }
            }
        }

    }

    @Override
    public void update() {

    }

    @Override
    public int[] getDefaultPosition() {
        return new int[]{1, 1};
    }

    public void draw(Graphics2D g) {
        g.setColor(backgroundColor);
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        for (int x = 0; x < numCols; x++) {
            for (int y = 0; y < numRows; y++) {
                tiles[rawMapData[y][x]].draw(g, x, y, tileWidth, tileHeight);
            }
        }
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public int getTileHeight() {
        return tileHeight;
    }
}
