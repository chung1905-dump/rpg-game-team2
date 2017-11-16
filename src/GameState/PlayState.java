package GameState;

import java.awt.*;

import Entity.Player;
import Manager.GameStateManager;
import Manager.TileMapManager;

public class PlayState extends AbstractGameState {
    private TileMapManager mapManager;
    private Player player;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        mapManager = new TileMapManager();
        player = new Player(mapManager.getCurrent());
    }

    public void update() {
        player.update();
    }

    public void draw(Graphics2D g) {
        mapManager.getCurrent().draw(g);
        player.draw(g);
    }

}
