package Manager;

import Map.AbstractMap;
import Map.Map2;
import Map.TestMap;

public class TileMapManager {
    private static final int NUM_MAPS = 2;
    private static final int TESTMAP = 0;
    private static final int MAP2 = 1;
    private static AbstractMap[] maps;
    private static int current;
    private static int previous;

//    private TileMapManager() {
//        maps = new AbstractMap[NUM_MAPS];
//        set(TESTMAP);
//    }

    public static void init() {
        maps = new AbstractMap[NUM_MAPS];
        set(TESTMAP
        );
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
        } else if (i == MAP2) {
            maps[i] = new Map2();
        }
    }


    public static void update() {
        maps[current].update();
    }

    private static void unload(int i) {
        maps[i] = null;
    }

}
