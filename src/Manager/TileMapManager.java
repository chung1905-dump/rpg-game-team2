package Manager;

import Map.*;

public class TileMapManager {
    private static AbstractMap[] maps;
    private static int current;
    private static int previous;

    private static final int NUM_MAPS = 1;
    private static final int TESTMAP = 0;

//    private TileMapManager() {
//        maps = new AbstractMap[NUM_MAPS];
//        set(TESTMAP);
//    }

    public static void init() {
        maps = new AbstractMap[NUM_MAPS];
        set(TESTMAP);
    }

    public static AbstractMap getCurrent() {
        return maps[current];
    }

    public static void set(int i) {
        previous = current;
        unload(previous);
        current = i;
        if (i == TESTMAP) {
            maps[i] = new TestMap();
        }
    }

    public static void update() {
        maps[current].update();
    }

    private static void unload(int i) {
        maps[i] = null;
    }

}
