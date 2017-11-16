package Map.Tiles;

import Entity.AbstractEntity;

import java.awt.*;

public class Grass extends AbstractTile {
    private static final String imgPath = "/images/map/tiles/grass.png";

    @Override
    public void draw(Graphics2D g, int x, int y, int w, int h) {
        g.drawImage(
                Tool.Image.loadImage(imgPath),
                x * w,
                y * h,
                w,
                h,
                null
        );
    }
}
