package Main;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;

import Manager.GameStateManager;

public class GamePanel extends JPanel implements Runnable {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
//    public static final float SCALE = 1;

    // drawing stuff
    private BufferedImage image;
    private Graphics2D g;

    // game state manager
    private GameStateManager gsm;

    // game loop stuff
    private Thread thread;
    private boolean running;
    private final int FPS = 60;
    private final int TARGET_TIME = 1000 / FPS;

    public GamePanel() {
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
    }

    public void run() {

        init();

        long start;
        long elapsed;
        long wait;

        // game loop
        while (running) {

            start = System.nanoTime();

            update();
            draw();
            drawToScreen();

            elapsed = System.nanoTime() - start;

            wait = TARGET_TIME - elapsed / 1000000;
            if (wait < 0) wait = TARGET_TIME;

            try {
                Thread.sleep(wait);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    // initializes fields
    private void init() {
        running = true;
        image = new BufferedImage(WIDTH, HEIGHT, 1);
        g = (Graphics2D) image.getGraphics();
        gsm = new GameStateManager();
    }

    // updates game
    private void update() {
        gsm.update();
//        Keys.update();
    }

    // draws game
    private void draw() {
        gsm.draw(g);
    }

    // copy buffer to screen
    private void drawToScreen() {
        Graphics g2 = getGraphics();
        g2.drawImage(image, 0, 0, WIDTH /** SCALE*/, HEIGHT /** SCALE*/, null);
        g2.dispose();
    }

    // ready to display
    public void addNotify() {
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        g.drawString("Java 2D!", 300, 220);
//    }
}
