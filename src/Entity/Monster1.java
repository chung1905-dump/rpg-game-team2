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
    private int speed = 4;
    private int w, h;

    public Monster1(int x, int y, int w, int h, AbstractMap map) {
        this.map = map;
        hp = 10;
        //x,y,w,h
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.rectangle = new Rectangle(x * w, y * h, w * 7 / 10, h * 7 / 10);
        //
        sightRectangle = getSightRectangle(rectangle);
        //load img
        if (img == null) {
            img = Tool.Image.loadImage("/entity/character/mbat1.png");
        }
    }

    @Override
    public void update() {
        Rectangle playerRectangle = Player.getInstance().getRectangle();
        if (rectangle.intersects(playerRectangle)) {
            Player.getInstance().setHp(0);
        } else if (sightRectangle.intersects(playerRectangle)) {
//            int[][] mapData = TileMapManager.getCurrent().getRawMapData();
            double[] move = findMove(rectangle.getX(), rectangle.getY(), playerRectangle.getX(), playerRectangle.getY());
            Rectangle dest = (Rectangle) rectangle.clone();
            dest.x += Math.ceil(move[0]);
            if (!TileMapManager.getCurrent().isBlock(dest)) {
                rectangle = dest;
            }
            dest = (Rectangle) rectangle.clone();
            dest.y += Math.ceil(move[1]);
            if (!TileMapManager.getCurrent().isBlock(dest)) {
                rectangle = dest;
            }
        }
        sightRectangle = getSightRectangle(rectangle);

    }

    private Rectangle getSightRectangle(Rectangle r) {
        return new Rectangle(r.x - 1 * w, r.y - 1 * h, w * 3, h * 3);
    }

    private double[] findMove(double sx, double sy, double tx, double ty) {
        double x = tx - sx;
        double y = ty - sy;
        double distance = Math.sqrt(x * x + y * y);
        x = x / distance * speed;
        y = y / distance * speed;
        return new double[]{x, y};
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
