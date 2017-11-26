package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Monster1 extends AbstractCharacter {
    private static BufferedImage img;

    public Monster1(int x, int y, int w, int h) {
        hp = 10;
        //x,y,w,h
        currentX = x * w;
        currentY = y * h;
        width = 64;
        height = 64;
        //load img
        if (img == null) {
            img = Tool.Image.loadImage("/entity/character/monster.png");
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(img, currentX, currentY, width, height, null);
    }
}
