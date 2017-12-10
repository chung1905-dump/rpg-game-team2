package Manager;

import GameState.*;

import java.awt.*;

public class GameStateManager {
    public static final int INTRO = 0;
    public static final int MENU = 1;
    public static final int PLAY = 2;
    public static final int OVER = 3;
    public static final int WIN = 4;
    private static final int NUM_STATES = 5 ;
    private AbstractGameState[] gameStates;
    private int currentState;
    private int previousState;

    private static GameStateManager instance;

    private GameStateManager() {
        gameStates = new AbstractGameState[NUM_STATES];
        setState(INTRO);
    }

    public static GameStateManager getInstance() {
        if (instance == null) {
            instance = new GameStateManager();
        }
        return instance;
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
        }else if (i == OVER) {
            gameStates[i] = new GameOverState(this);
            gameStates[i].init();
        }else if (i == WIN) {
            gameStates[i] = new WinState(this);
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
