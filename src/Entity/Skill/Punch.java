package Entity.Skill;

import Entity.AbstractCharacter;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Punch extends AbstractSkill {
    private AbstractCharacter source;

    private int during;
    // x, y, w, h for drawing purpose
//    private int x;
//    private int y;
    private final int w = 30;
    private final int h = 30;
    // rectangle for collision checking
    private Rectangle rectangle;

    private static BufferedImage img;

    public Punch() {
        if (img == null) {
            img = Tool.Image.loadImage("/entity/skills/punch.png");
        }
    }

    @Override
    public Punch init(AbstractCharacter character) {
        int x = 0, y = 0;
        Punch ret = new Punch();
        ret.source = character;
        ret.during = 0;
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
        character.die();
    }

    @Override
    public void update() {
        this.during++;
    }

    @Override
    public void draw(Graphics2D g) {
        int x = (int) rectangle.getX();
        int y = (int) rectangle.getY();
        g.drawImage(img, x, y, w, h, null);
    }

    @Override
    public boolean isEnd() {
        return during > 1;
    }
}
