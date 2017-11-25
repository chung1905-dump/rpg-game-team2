package GameState;

import java.awt.Graphics2D;
import Manager.GameStateManager;

public abstract class AbstractGameState{
    protected GameStateManager gsm;

    public AbstractGameState(GameStateManager gsm){
        this.gsm = gsm;
    }
    public abstract void init();
    public abstract void update();
    public abstract void draw(Graphics2D g);
    public abstract void handleInput();
}
