package Tool;

import Interface.Blockable;

import java.awt.*;
import java.util.ArrayList;

public final class Collision {
    private static ArrayList<Blockable> blocks = new ArrayList<Blockable>();
    private static ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();

    public static void addBlock(Blockable a, Rectangle r) {
        blocks.add(a);
        rectangles.add(r);
    }

    public static boolean isBlock(Rectangle r) {
        for (int i = 0; i < blocks.size(); i++) {
            if (rectangles.get(i).intersects(r)) {
                return true;
            }
        }
        return false;

    }
}
