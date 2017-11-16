package Map.Tiles;

import Entity.AbstractEntity;
import Interface.Blockable;

import java.awt.*;

public class Water extends AbstractTile implements Blockable {
    private static final String imgPath = "/images/map/tiles/water.png";

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
