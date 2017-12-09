package Entity;

import Manager.TileMapManager;
import Map.AbstractMap;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Monster1 extends AbstractCharacter {
    private static BufferedImage img;
    //    private AbstractMap map;
    // to check if player in sight
    private Rectangle sightRectangle;

    public Monster1(int x, int y, int w, int h, AbstractMap map) {
        this.map = map;
        hp = 10;
        //x,y,w,h
        this.x = x;
        this.y = y;
        this.rectangle = new Rectangle(x * w, y * h, w, h);
        //
        sightRectangle = new Rectangle(x - 1, y - 1, w * 3, h * 3);
        //load img
        if (img == null) {
            img = Tool.Image.loadImage("/entity/character/monster.png");
        }
    }

    @Override
    public void update() {
        Rectangle playerRectangle = Player.getInstance().getRectangle();
        if (sightRectangle.intersects(playerRectangle)) {
            int[][] mapData = TileMapManager.getCurrent().getRawMapData();
            int i = 0;
        }
    }

    private int[] findMove(int sx, int sy, int tx, int ty, int[][] map) {
        int[] path = new int[0];

        return path;
    }

    @Override
    public int[] getGridXY() {
        return new int[]{(int) rectangle.getX() / map.getTileWidth(), (int) rectangle.getY() / map.getTileHeight()};
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(img, rectangle.x, rectangle.y, rectangle.width, rectangle.height, null);
    }
}
