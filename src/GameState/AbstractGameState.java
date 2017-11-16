package GameState;

import Manager.GameStateManager;

import java.awt.*;

abstract public class AbstractGameState {
    protected GameStateManager gsm;

    public AbstractGameState(GameStateManager gsm) {
        this.gsm = gsm;
    }

    abstract public void update();

    abstract public void draw(Graphics2D g);
}
