package Manager;

import java.awt.Graphics2D;
import GameState.*;

public class GameStateManager {
    private AbstractGameState[] gameStates;
    private int currentState;
    private int previousState;

    public static final int NUM_STATES = 2;
    public static final int INTRO = 0;
    public static final int MENU = 1;

    public GameStateManager() {
        gameStates = new AbstractGameState[NUM_STATES];
        setState(INTRO);
    }

    public void setState(int i) {
        previousState = currentState;
        unloadState(previousState);
        currentState = i;
        if(i == INTRO) {
            gameStates[i] = new IntroState(this);
            gameStates[i].init();
        } else if (i == MENU) {
            gameStates[i] = new MenuState(this);
            gameStates[i].init();
        }
    }

    public void unloadState(int i) {
        gameStates[i] = null;
    }

    public void update() {
        if(gameStates[currentState] != null) {
            gameStates[currentState].update();
        }
    }

    public void draw(Graphics2D g) {
        if(gameStates[currentState] != null) {
            gameStates[currentState].draw(g);
        }
    }

}
