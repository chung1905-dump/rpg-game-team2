package Map.Tiles;

import Interface.Blockable;
import Tool.Image;

import java.awt.*;

public class Tree extends AbstractTile implements Blockable {
    private static final String imgPath = "/images/map/tiles/tree.png";

    @Override
    public void draw(Graphics2D g, int x, int y, int w, int h) {
        g.drawImage(
                Image.loadImage(imgPath),
                x * w,
                y * h,
                w,
                h,
                null
        );
    }
}
