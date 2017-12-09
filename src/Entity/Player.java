package Entity;

import Entity.Skill.AbstractSkill;
import Entity.Skill.Firebow;
import Entity.Skill.Punch;
import Main.GamePanel;
import Manager.TileMapManager;
import Map.AbstractMap;
import Tool.Keys;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends AbstractCharacter {
    private static Player instance;
    private static BufferedImage img[][];

    final private String imgPath = "/entity/character/character.png";
    private AbstractMap map;
    private int moveSpeed = 160;

    private int moveStep = 0;
    private boolean isMoving = false;

    private AbstractSkill skills[];
    private ArrayList<AbstractSkill> currentActiveSkills = new ArrayList<>();

    private int PUNCH = 0;
    private int FIRE_BOW = 1;

    private final double SCALE = 0.8;

    private Player() {
        hp = 10;
        facing = AbstractCharacter.DOWN;
        map = TileMapManager.getCurrent();
        // scale character to 4/5 a block tile
        x = map.getDefaultPosition()[0];
        y = map.getDefaultPosition()[1];
        int xcoord = x * map.getTileWidth();
        int ycoord = y * map.getTileHeight();
        double width = map.getTileWidth() * SCALE;
        double height = map.getTileHeight() * SCALE;

        rectangle = new Rectangle(xcoord, ycoord, (int) width, (int) height);
        loadSkill();
        loadSprites();
    }

    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    private void loadSkill() {
        skills = new AbstractSkill[2];
        skills[PUNCH] = new Punch();
        skills[FIRE_BOW] = new Firebow();
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
    }

    private BufferedImage getImg() {
        if (!isMoving) {
            return img[facing][0];
        }
        return img[facing][moveStep / (GamePanel.FPS / 3) % 2 + 1];
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
        if (Keys.isDown(KeyEvent.VK_UP)) {
            move(UP, getMoveSpeed());
        }
        if (Keys.isDown(KeyEvent.VK_DOWN)) {
            move(DOWN, getMoveSpeed());
        }
        if (Keys.isDown(KeyEvent.VK_RIGHT)) {
            move(RIGHT, getMoveSpeed());
        }
        if (Keys.isDown(KeyEvent.VK_LEFT)) {
            move(LEFT, getMoveSpeed());
        }
        if (Keys.isPressed(KeyEvent.VK_SPACE)) {
            currentActiveSkills.add(skills[PUNCH].init(this)); //space to use punch
        }
        if (Keys.isPressed(KeyEvent.VK_Q)) {
            currentActiveSkills.add(skills[FIRE_BOW].init(this)); //Q to use firebow
        }
        if (!isMoving) {
            moveStep = 0;
        }
    }

    private void move(int i, int speed) {
        isMoving = true;
        facing = i;
        moveStep++;
        Rectangle dest = (Rectangle) rectangle.clone();
        switch (i) {
            case UP:
                dest.y -= speed;
                break;
            case DOWN:
                dest.y += speed;
                break;
            case LEFT:
                dest.x -= speed;
                break;
            case RIGHT:
                dest.x += speed;
                break;
        }
        if (!this.map.isBlock(dest)) {
            rectangle = dest;
        }
    }

    @Override
    public boolean isDie() {
        return false;
    }

    public int getMoveSpeed() {
        return moveSpeed / GamePanel.FPS;
    }

    // need fix
    public void draw(Graphics2D g) {
        g.drawImage(getImg(), rectangle.x, rectangle.y, rectangle.width, rectangle.height, null);
        // warning 2 same loop
        for (AbstractSkill e : currentActiveSkills) {
            e.draw(g);
        }
    }
}
