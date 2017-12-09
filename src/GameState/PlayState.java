package GameState;

import Entity.Player;
import Manager.GameStateManager;
import Manager.TileMapManager;
import HUD.HUD;

import java.awt.*;

public class PlayState extends AbstractGameState {
    //    private static TileMapManager mapManager;
    private Player player;
    private HUD hud;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        TileMapManager.init();
        player = new Player(TileMapManager.getCurrent());
    }

    @Override
    public void init() {
        hud = new HUD(player);
    }

    public void update() {
        TileMapManager.update();
        player.update();
    }

    public void draw(Graphics2D g) {
        TileMapManager.getCurrent().draw(g);
        player.draw(g);
        hud.draw(g);
    }

    @Override
    public void handleInput() {

    }

}
