package Map.Tiles;

import Interface.Blockable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tree extends AbstractTile implements Blockable {
    private static BufferedImage img;

    public Tree() {
        if (img == null) {
            img = Tool.Image.loadImage("/images/map/tiles/tree.png");
        }
    }

    @Override
    public void draw(Graphics2D g, int x, int y, int w, int h) {
        g.drawImage(
                img,
                x * w,
                y * h,
                w,
                h,
                null
        );
    }
}
