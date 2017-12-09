package Entity.Skill;

import Entity.AbstractCharacter;
import Manager.TileMapManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Punch extends AbstractSkill {
    private static BufferedImage img;
    private static BufferedImage img2;
    private static BufferedImage img3;
    private static BufferedImage img4;
    // x, y, w, h for drawing purpose
//    private int x;
//    private int y;
    private final int w = 30;
    private final int h = 30;
    private AbstractCharacter source;
    private int during;
    private int facing;
    // rectangle for collision checking
    private Rectangle rectangle;

    public Punch() {
        if (img == null) {
            img = Tool.Image.loadImage("/entity/skills/punch2.png");
            img2 = Tool.Image.loadImage("/entity/skills/punch3.png");
            img3 = Tool.Image.loadImage("/entity/skills/punch4.png");
            img4 = Tool.Image.loadImage("/entity/skills/pixil-frame-0.png");
        }
    }

    @Override
    public Punch init(AbstractCharacter character) {
        int x = 0, y = 0;
        Punch ret = new Punch();
        ret.source = character;
        ret.facing = character.getFacing();
        switch (character.getFacing()) {
            case AbstractCharacter.UP:
                x = character.getX() + character.getWidth() / 2 - w / 2;
                y = character.getY() - h;
                break;
            case AbstractCharacter.DOWN:
                x = character.getX() + character.getWidth() / 2 - w / 2;
                y = character.getY() + character.getHeight();
                break;
            case AbstractCharacter.LEFT:
                x = character.getX() - w;
                y = character.getY() + character.getHeight() / 2 - h / 2;
                break;
            case AbstractCharacter.RIGHT:
                x = character.getX() + character.getWidth();
                y = character.getY() + character.getHeight() / 2 - h / 2;
                break;
        }
        ret.rectangle = new Rectangle(x, y, w, h);
        return ret;
    }

    @Override
    public void execute(AbstractCharacter character) {
        character.setHp(0);
    }

    @Override
    public void update() {
        this.during++;
        ArrayList<AbstractCharacter> mons = TileMapManager.getCurrent().getMonsters();
        for (AbstractCharacter m : mons) {
            if (rectangle.intersects(new Rectangle(m.getX(), m.getY(), m.getWidth(), m.getHeight()))) {
                execute(m);
            }
        }
    }

    @Override
    public void draw(Graphics2D g) {
        int x = (int) rectangle.getX();
        int y = (int) rectangle.getY();
        switch (facing)
        {
            case AbstractCharacter.UP:
                g.drawImage(img, x, y, w, h, null);
                break;
            case AbstractCharacter.DOWN:
                g.drawImage(img2, x, y, w, h, null);
                break;
            case AbstractCharacter.LEFT:
                g.drawImage(img3, x, y, w, h, null);
                break;
            case AbstractCharacter.RIGHT:
                g.drawImage(img4, x, y, w, h, null);
                break;
        }
    }

    @Override
    public boolean isEnd() {
        return during > 1;
    }
}
