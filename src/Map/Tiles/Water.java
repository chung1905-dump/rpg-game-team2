package Map.Tiles;

import Interface.Blockable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Water extends AbstractTile implements Blockable {
    private static BufferedImage img;

    public Water () {
        if (img == null) {
            img = Tool.Image.loadImage("/images/map/tiles/water.png");
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
