package Tool;

import Interface.Blockable;

import java.awt.*;
import java.util.ArrayList;

public final class Collision {
    private static ArrayList<Blockable> blocks = new ArrayList<>();
    private static ArrayList<Rectangle> blockRectangles = new ArrayList<>();

    public static void addBlock(Blockable a, Rectangle r) {
        blocks.add(a);
        blockRectangles.add(r);
    }

    public static boolean isBlock(Rectangle r) {
        for (int i = 0; i < blocks.size(); i++) {
            if (blockRectangles.get(i).intersects(r)) {
                return true;
            }
        }
        return false;

    }
}
