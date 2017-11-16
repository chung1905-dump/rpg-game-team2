package Manager;

import Map.*;

public class TileMapManager {
    private AbstractMap[] maps;
    private int current;
    private int previous;

    private static final int NUM_MAPS = 1;
    private static final int TESTMAP = 0;

    public TileMapManager() {
        maps = new AbstractMap[NUM_MAPS];
        set(TESTMAP);
    }

    public AbstractMap getCurrent() {
        return maps[current];
    }

    public void set(int i) {
        previous = current;
        unload(previous);
        current = i;
        if (i == TESTMAP) {
            maps[i] = new TestMap();
        }
    }

    private void unload(int i) {
        maps[i] = null;
    }

}
