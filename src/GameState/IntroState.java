package GameState;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import Manager.GameStateManager;
import Main.GamePanel;

public class IntroState extends AbstractGameState {
    private BufferedImage logo;

    private int alpha;
    private int ticks;

    private final int FADE_IN = 60;
    private final int LENGTH = 60;
    private final int FADE_OUT = 60;

    public IntroState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        ticks = 0;
        try {
            logo = ImageIO.read(getClass().getResourceAsStream("/images/map/block/grass.png"));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        handleInput();
        ticks++;
        if(ticks < FADE_IN) {
            alpha = (int) (255 - 255 * (1.0 * ticks / FADE_IN));
            if(alpha < 0) alpha = 0;
        }
        if(ticks > FADE_IN + LENGTH) {
            alpha = (int) (255 * (1.0 * ticks - FADE_IN - LENGTH) / FADE_OUT);
            if(alpha > 255) alpha = 255;
        }
        if(ticks > FADE_IN + LENGTH + FADE_OUT) {
//            gsm.setState(GameStateManager.OUTTRO);
        }
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
        g.drawImage(logo, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
        g.setColor(new Color(0, 0, 0, alpha));
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
    }

    public void handleInput() {
//        if(Keys.isPressed(Keys.ENTER)) {
//            gsm.setState(GameStateManager.MENU);
//        }
    }


}
