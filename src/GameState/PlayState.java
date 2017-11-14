package GameState;

import java.awt.*;
import java.util.ArrayList;

import Map.*;
import Manager.GameStateManager;
import Main.GamePanel;
import Entity.Player;
import Manager.Keys;

public class PlayState extends AbstractGameState {
    protected TileMap tileMap;
    // player
    private Player player;

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

        // create player
        player = new Player(tileMap);

        // initialize player
        player.setTilePosition(17, 17);
        player.setTotalDiamonds(0);

//         set up camera position
        sectorSize = GamePanel.WIDTH;
        xsector = player.getx() / sectorSize;
        ysector = player.gety() / sectorSize;
//        tileMap.setPositionImmediately(-xsector * sectorSize, -ysector * sectorSize);

    }

    public void update() {
        handleInput();
        // update camera
        int oldxs = xsector;
        int oldys = ysector;
        xsector = player.getx() / sectorSize;
        ysector = player.gety() / sectorSize;
//        tileMap.setPosition(-xsector * sectorSize, -ysector * sectorSize);
        tileMap.update();

        player.update();

    }

    public void draw(Graphics2D g) {
        // draw tilemap
        tileMap.draw(g);
        // draw player
        player.draw(g);

    }

    public void handleInput() {
        if(Keys.isDown(Keys.LEFT)) player.setLeft();
        if(Keys.isDown(Keys.RIGHT)) player.setRight();
        if(Keys.isDown(Keys.UP)) player.setUp();
        if(Keys.isDown(Keys.DOWN)) player.setDown();
        if(Keys.isPressed(Keys.SPACE)) player.setAction();

    }

}
