package Entity.Skill;

import Entity.AbstractCharacter;
import Main.GamePanel;
import Manager.TileMapManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Firebow extends AbstractSkill {
    private static BufferedImage img;
    // x, y, w, h for drawing purpose
//    private int x;
//    private int y;
    private final int w = 70;
    private final int h = 70;
    private AbstractCharacter source;
    private int facing;
    private int speed = 12;
    // rectangle for collision checking
    private Rectangle rectangle;

    public Firebow() {
        if (img == null) {
            img = Tool.Image.loadImage("/entity/skills/firebow.png");
        }
    }

    @Override
    public Firebow init(AbstractCharacter character) {
        int x = 0, y = 0;
        Firebow ret = new Firebow();
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
        switch (facing) {
            case AbstractCharacter.UP:
                rectangle.setLocation((int) rectangle.getX(), (int) rectangle.getY() - speed);
                break;
            case AbstractCharacter.DOWN:
                rectangle.setLocation((int) rectangle.getX(), (int) rectangle.getY() + speed);
                break;
            case AbstractCharacter.LEFT:
                rectangle.setLocation((int) rectangle.getX() - speed, (int) rectangle.getY());
                break;
            case AbstractCharacter.RIGHT:
                rectangle.setLocation((int) rectangle.getX() + speed, (int) rectangle.getY());
                break;
        }
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
        g.drawImage(img, x, y, w, h, null);
    }

    @Override
    public boolean isEnd() {
        return (rectangle.getX() < -w ||
                rectangle.getX() > GamePanel.WIDTH ||
                rectangle.getY() < -h ||
                rectangle.getY() > GamePanel.HEIGHT

        );
    }
}
