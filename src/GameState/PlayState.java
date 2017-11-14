package GameState;

import java.awt.*;
import java.util.ArrayList;

import Map.*;

import Manager.GameStateManager;
import Main.GamePanel;

public class PlayState extends AbstractGameState {
    protected TileMap tileMap;

    // camera position
    private int xsector;
    private int ysector;
    private int sectorSize;

    public PlayState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        tileMap = new TileMap(16);
        tileMap.loadTiles("/images/map/tileset.gif");
        tileMap.loadMap("/maps/map1.map");

        // set up camera position
//        sectorSize = GamePanel.WIDTH;
//        xsector = player.getx() / sectorSize;
//        ysector = player.gety() / sectorSize;
//        tileMap.setPositionImmediately(-xsector * sectorSize, -ysector * sectorSize);

    }

    public void update() {
        tileMap.update();
    }

    public void draw(Graphics2D g) {
        // draw tilemap
        tileMap.draw(g);
    }

    public void handleInput() {
    }
}
