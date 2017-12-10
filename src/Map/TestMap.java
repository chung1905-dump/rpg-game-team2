package Map;

import Entity.AbstractCharacter;
import Entity.Monster1;
import Interface.BlockTile;
import Interface.PortalTile;
import Main.GamePanel;
import Manager.TileMapManager;
import Map.Tiles.*;

import java.awt.*;
import java.util.ArrayList;

public class TestMap extends AbstractMap {
    //define col x row
    private final int numCols = 10;
    private final int numRows = 10;

    //background color
    private final Color backgroundColor = new Color(166, 226, 107);
    private final int NUM_TILES = 4;
    private final int GRASS_TILE = 0;
    private final int WATER_TILE = 1;
    private final int TREE_TILE = 2;
    private final int PORTAL_TILE = 3;
    //contains array of integer 0, 1, 2, 3
    private int rawMapData[][];
    //tiles are used in map
    private AbstractTile tiles[];
    private int tileWidth;
    private int tileHeight;

    public TestMap() {
        tiles = new AbstractTile[NUM_TILES];
        tiles[GRASS_TILE] = new Grass();
        tiles[WATER_TILE] = new Water();
        tiles[TREE_TILE] = new Tree();
        tiles[PORTAL_TILE] = new Portal();

        tileWidth = GamePanel.WIDTH / numCols;
        tileHeight = GamePanel.HEIGHT / numRows;
        //define map content
        rawMapData = getRawMapData();
        //save tiles blocking player's movement
        blockRectangles = new ArrayList<>();
        for (int x = 0; x < numCols; x++) {
            for (int y = 0; y < numRows; y++) {
                if (tiles[rawMapData[y][x]] instanceof BlockTile) {
                    addBlock(
                            new Rectangle(x * tileWidth, y * tileHeight, tileWidth, tileHeight)
                    );
                } else if (tiles[rawMapData[y][x]] instanceof PortalTile) {
                    setPortalRectangle(
                            new Rectangle(x * tileWidth, y * tileHeight, tileWidth, tileHeight)
                    );
                }
            }
        }

        initMonsters();
    }

    @Override
    public int[][] getRawMapData() {
//        private final int GRASS_TILE = 0;
//        private final int WATER_TILE = 1;
//        private final int TREE_TILE = 2;
//        private final int PORTAL_TILE = 3;

        return new int[][]{
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                {2, 0, 2, 0, 0, 0, 0, 0, 2, 2},
                {2, 0, 0, 1, 0, 0, 0, 0, 2, 2},
                {2, 0, 0, 1, 1, 0, 0, 0, 2, 2},
                {2, 0, 0, 1, 1, 0, 1, 0, 2, 2},
                {2, 0, 0, 1, 1, 0, 0, 0, 2, 2},
                {2, 0, 0, 1, 1, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        };
    }

    private void initMonsters() {
        monsters = new ArrayList<>();
        monsters.add(new Monster1(7, 5, tileWidth, tileHeight, this));
    }


    @Override
    public void update() {
        for (int i = 0; i < monsters.size(); i++) {
            AbstractCharacter m = monsters.get(i);
            m.update();
            if (m.isDie()) {
                monsters.remove(m);
            }
        }
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
        for (AbstractCharacter m : monsters) {
            m.draw(g);
        }
    }

    @Override
    public AbstractMap next() {
        TileMapManager.set(TileMapManager.MAP2);
        return TileMapManager.getCurrent();
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public int getTileHeight() {
        return tileHeight;
    }
}
