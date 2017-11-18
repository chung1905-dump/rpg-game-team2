package Map.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Grass extends AbstractTile {
    private static BufferedImage img;

    public Grass() {
        if (img == null) {
            img = Tool.Image.loadImage("/images/map/tiles/grass.png");
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
