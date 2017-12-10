package Map.Tiles;

import Entity.AbstractCharacter;
import Interface.PortalTile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Portal extends AbstractTile implements PortalTile {
    private static BufferedImage img;

    public Portal() {
        if (img == null) {
            img = Tool.Image.loadImage("/images/map/tiles/portal.gif");
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
