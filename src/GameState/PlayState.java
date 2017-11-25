package GameState;

import java.awt.*;

import Entity.Player;
import Manager.GameStateManager;
import Manager.TileMapManager;

public class PlayState extends AbstractGameState {
//    private static TileMapManager mapManager;
    private Player player;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        TileMapManager.init();
        player = new Player(TileMapManager.getCurrent());
    }

    @Override
    public void init() {

    }

    public void update() {
        TileMapManager.update();
        player.update();
    }

    public void draw(Graphics2D g) {
        TileMapManager.getCurrent().draw(g);
        player.draw(g);
    }

    @Override
    public void handleInput() {

    }

}
