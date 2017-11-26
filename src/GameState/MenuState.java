package GameState;

import Manager.Content;
import Manager.GameStateManager;
import Tool.Keys;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class MenuState extends AbstractGameState {
    private BufferedImage bg;
    private BufferedImage diamond;

    private int currentOption = 0;
    private String[] options = {
            "START",
            "QUIT"
    };

    public MenuState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        Content cnt = new Content();
        bg = Content.MENUBG[0][0];
        diamond = Content.DIAMOND[0][0];
    }

    public void update() {
        handleInput();
    }

    public void draw(Graphics2D g) {
        g.drawImage(bg, 0, 0, null);

        Content.drawString(g, options[0], 330, 270);
        Content.drawString(g, options[1], 330, 300);

        if (currentOption == 0) g.drawImage(diamond, 310, 270, 20, 20, null);
        else if (currentOption == 1) g.drawImage(diamond, 310, 300, 20, 20, null);
    }

    public void handleInput() {
        if (Keys.isPressed(KeyEvent.VK_DOWN) && currentOption < options.length - 1) {
            currentOption++;
        }
        if (Keys.isPressed(KeyEvent.VK_UP) && currentOption > 0) {
            currentOption--;
        }
        if (Keys.isPressed(KeyEvent.VK_ENTER)) {
            selectOption();
        }
    }

    public void selectOption() {
        if (currentOption == 0) {
            gsm.setState(GameStateManager.PLAY);
        }
        if (currentOption == 1) {
            System.exit(0);
        }
    }
}
