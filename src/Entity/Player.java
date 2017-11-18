package Entity;

import Entity.Skill.AbstractSkill;
import Entity.Skill.Punch;
import Tool.Collision;
import Tool.Keys;
import Map.AbstractMap;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

public class Player extends AbstractCharacter {
    final private String imgPath = "/entity/character/character.png";
    private static BufferedImage img[][];
    private AbstractMap map;
    private int moveSpeed = 8;

    private int moveStep = 0;
    private boolean isMoving = false;

    private AbstractSkill skills[];
    private ArrayList<AbstractSkill> currentActiveSkills = new ArrayList<>();

    public Player(AbstractMap m) {
        facing = AbstractCharacter.DOWN;
        map = m;
        width = map.getTileWidth() * 4 / 5;
        height = map.getTileHeight() * 4 / 5;
        currentX = map.getDefaultPosition()[0] * width * 5 / 4;
        currentY = map.getDefaultPosition()[1] * height * 5 / 4;
        loadSkill();
        loadSprites();
    }

    private void loadSkill() {
        skills = new AbstractSkill[1];
        skills[0] = new Punch();
    }

    private void loadSprites() {
        img = new BufferedImage[4][3];
        img[UP][0] = Tool.Image.loadImage("/entity/character/char10.png");
        img[UP][1] = Tool.Image.loadImage("/entity/character/char11.png");
        img[UP][2] = Tool.Image.loadImage("/entity/character/char12.png");

        img[DOWN][0] = Tool.Image.loadImage("/entity/character/char00.png");
        img[DOWN][1] = Tool.Image.loadImage("/entity/character/char01.png");
        img[DOWN][2] = Tool.Image.loadImage("/entity/character/char02.png");

        img[LEFT][0] = Tool.Image.loadImage("/entity/character/char30.png");
        img[LEFT][1] = Tool.Image.loadImage("/entity/character/char31.png");
        img[LEFT][2] = Tool.Image.loadImage("/entity/character/char32.png");

        img[RIGHT][0] = Tool.Image.loadImage("/entity/character/char20.png");
        img[RIGHT][1] = Tool.Image.loadImage("/entity/character/char21.png");
        img[RIGHT][2] = Tool.Image.loadImage("/entity/character/char22.png");

//        img[UP][0] = Tool.Image.loadImage(imgPath, 130, 33, 16, 16);
//        img[UP][1] = Tool.Image.loadImage(imgPath, 146, 33, 16, 16);
//        img[UP][2] = Tool.Image.loadImage(imgPath, 162, 33, 16, 16);
//
//        img[DOWN][0] = Tool.Image.loadImage(imgPath, 130, 0, 14, 16);
//        img[DOWN][1] = Tool.Image.loadImage(imgPath, 146, 0, 14, 16);
//        img[DOWN][2] = Tool.Image.loadImage(imgPath, 162, 0, 14, 16);
//
//        img[LEFT][0] = Tool.Image.loadImage(imgPath, 130, 17, 16, 16);
//        img[LEFT][1] = Tool.Image.loadImage(imgPath, 146, 17, 16, 16);
//        img[LEFT][2] = Tool.Image.loadImage(imgPath, 162, 17, 16, 16);
//
//        img[RIGHT][0] = Tool.Image.loadImage(imgPath, 130, 17, 16, 16);
//        img[RIGHT][1] = Tool.Image.loadImage(imgPath, 146, 17, 16, 16);
//        img[RIGHT][2] = Tool.Image.loadImage(imgPath, 162, 17, 16, 16);
    }

    private BufferedImage getImg() {
        if (!isMoving) {
            return img[facing][0];
        }
        return img[facing][moveStep / 8 % 2 + 1];
    }

    public void update() {
        handleInput();
        for (int i = 0; i < currentActiveSkills.size(); i++) {
            AbstractSkill e = currentActiveSkills.get(i);
            e.update();
            if (e.isEnd()) {
                currentActiveSkills.remove(i);
            }
        }
    }

    private void handleInput() {
        isMoving = false;
        if (Keys.isDown(Keys.UP)) {
            move(UP, moveSpeed);
        }
        if (Keys.isDown(Keys.DOWN)) {
            move(DOWN, moveSpeed);
        }
        if (Keys.isDown(Keys.RIGHT)) {
            move(RIGHT, moveSpeed);
        }
        if (Keys.isDown(Keys.LEFT)) {
            move(LEFT, moveSpeed);
        }
        if (Keys.isPressed(Keys.SPACE)) {
            currentActiveSkills.add(skills[0].init(this));
        }
        if (!isMoving) {
            moveStep = 0;
        }
    }

    private void move(int i, int speed) {
        isMoving = true;
        facing = i;
        moveStep++;
        int dest;
        switch (i) {
            case UP:
                dest = currentY - speed;
                if (!Collision.isBlock(new Rectangle(currentX, dest, width, height))) {
                    currentY = dest;
                }
                break;
            case DOWN:
                dest = currentY + speed;
                if (!Collision.isBlock(new Rectangle(currentX, dest, width, height))) {
                    currentY = dest;
                }
                break;
            case LEFT:
                dest = currentX - speed;
                if (!Collision.isBlock(new Rectangle(dest, currentY, width, height))) {
                    currentX = dest;
                }
                break;
            case RIGHT:
                dest = currentX + speed;
                if (!Collision.isBlock(new Rectangle(dest, currentY, width, height))) {
                    currentX = dest;
                }
                break;
        }
    }

    @Override
    public void die() {
    }

    // need fix
    public void draw(Graphics2D g) {
        g.drawImage(getImg(), currentX, currentY, width, height, null);
        // warning 2 same loop
        for (AbstractSkill e : currentActiveSkills) {
            e.draw(g);
        }
    }
}
