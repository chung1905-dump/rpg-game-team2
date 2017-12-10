package GameState;

import Main.GamePanel;
import Manager.GameStateManager;
import Tool.Keys;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class WinState extends AbstractGameState {
    private final int FADE_IN = 120;
    private final int LENGHT = 120;
    private final int FADE_OUT = 120;
    private BufferedImage logo;
    private int alpha;
    private int ticks;

    public WinState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        ticks = 0;
        try {
            logo = ImageIO.read(getClass().getResourceAsStream("/images/logo/Win.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        handleInput();
//        ticks++;
//        if (ticks < FADE_IN) {
//            alpha = (int) (255 - 255 * (1.0 * ticks / FADE_IN));
//            if (alpha < 0) alpha = 0;
//        }
//        if (ticks > FADE_IN + LENGHT) {
//            alpha = (int) (255 * (1.0 * ticks - FADE_IN - LENGHT) / FADE_OUT);
//            if (alpha > 255) alpha = 255;
//        }
//        if (ticks > FADE_IN + LENGHT + FADE_OUT) {
//            gsm.setState(GameStateManager.MENU);
//        }
    }

    public void draw(Graphics2D g) {
//        g.setC
//        Rect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        g.drawImage(logo, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
//        g.setColor(new Color(28, 50, 73, alpha));
//        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
    }

    public void handleInput() {
        if (Keys.isPressed(KeyEvent.VK_ENTER)) {
            gsm.setState(GameStateManager.MENU);
        }
    }

}
