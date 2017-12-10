package GameState;

import Main.GamePanel;
import Manager.GameStateManager;
import Tool.Keys;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class GameOverState extends AbstractGameState {
    private final int FADE_IN = 120;
    private final int LENGHT = 120;
    private final int FADE_OUT = 120;
    private BufferedImage logo;
    private int alpha;
    private int ticks;

    public GameOverState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        ticks = 0;
        try {
            logo = ImageIO.read(getClass().getResourceAsStream("/images/logo/over.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        handleInput();

    }

    public void draw(Graphics2D g) {

        g.drawImage(logo, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);

    }

    public void handleInput() {
        if (Keys.isPressed(KeyEvent.VK_ENTER)) {
            gsm.setState(GameStateManager.MENU);
        }
    }

}
