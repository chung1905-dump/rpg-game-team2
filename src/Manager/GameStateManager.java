package Manager;

import GameState.AbstractGameState;
import GameState.IntroState;
import GameState.MenuState;
import GameState.PlayState;

import java.awt.*;

public class GameStateManager {
    public static final int INTRO = 0;
    public static final int MENU = 1;
    public static final int PLAY = 2;
    private static final int NUM_STATES = 3;
    private AbstractGameState[] gameStates;
    private int currentState;
    private int previousState;

    public GameStateManager() {
        gameStates = new AbstractGameState[NUM_STATES];
        setState(INTRO);
    }

    public void setState(int i) {
        previousState = currentState;
        unloadState(previousState);
        currentState = i;
        if (i == INTRO) {
            gameStates[i] = new IntroState(this);
            gameStates[i].init();
        } else if (i == MENU) {
            gameStates[i] = new MenuState(this);
            gameStates[i].init();
        } else if (i == PLAY) {
            gameStates[i] = new PlayState(this);
            gameStates[i].init();
        }
    }

    public void unloadState(int i) {
        gameStates[i] = null;
    }

    public void update() {
        if (gameStates[currentState] != null) {
            gameStates[currentState].update();
        }
    }

    public void draw(Graphics2D g) {
        if (gameStates[currentState] != null) {
            gameStates[currentState].draw(g);
        }
    }
}
