package GameState;

import java.awt.*;
import java.awt.image.BufferedImage;

import Manager.GameStateManager;
import Manager.Content;
import Manager.Keys;

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

        Content.drawString(g, options[0], 350, 390);
        Content.drawString(g, options[1], 350, 420);

        if (currentOption == 0) g.drawImage(diamond, 325, 394, 20, 20, null);
        else if (currentOption == 1) g.drawImage(diamond, 325, 424, 20, 20, null);
    }

    public void handleInput() {
        if(Keys.isPressed(Keys.DOWN) && currentOption < options.length - 1) {
            currentOption++;
        }
        if(Keys.isPressed(Keys.UP) && currentOption > 0) {
            currentOption--;
        }
        if(Keys.isPressed(Keys.ENTER)) {
            selectOption();
        }
    }

    private void selectOption() {
        if(currentOption == 0) {
//            gsm.setState(GameStateManager.PLAY);
        }
        if(currentOption == 1) {
            System.exit(0);
        }
    }


}
