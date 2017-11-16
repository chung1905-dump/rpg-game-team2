package Manager;

import GameState.*;

public class GameStateManager {
    private AbstractGameState[] gameStates;
    private int currentState;
    private int previousState;

    private static final int NUM_STATES = 1;
    private static final int PLAY = 0;

    public GameStateManager() {
        gameStates = new AbstractGameState[NUM_STATES];
        set(PLAY);
    }

    public AbstractGameState getCurrent() {
        return gameStates[currentState];
    }

    public void set(int i) {
        previousState = currentState;
        unload(previousState);
        currentState = i;
        if (i == PLAY) {
            gameStates[i] = new PlayState(this);
        }
    }

    private void unload(int i) {
        gameStates[i] = null;
    }

}
