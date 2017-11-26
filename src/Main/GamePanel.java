package Main;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import Manager.*;
import Tool.Keys;

public class GamePanel extends JPanel implements Runnable, KeyListener {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;

    //cong cu ve
    private BufferedImage image;
    private Graphics2D g;

    //game state manager
    private GameStateManager gsm;

    //game loop stuff
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

        //game loop:vong lap
        while (running) {
            start = System.nanoTime();

            update();
            draw();
            drawToScreen();

            elapsed = (System.nanoTime() - start) / 1000000;

            wait = TARGET_TIME - elapsed;
            if (wait < 0) wait = TARGET_TIME;

            try {
                Thread.sleep(wait);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //initializes fields : khoi tao cac truong
    private void init() {
        running = true;
        image = new BufferedImage(WIDTH, HEIGHT, 1);// tạo 1 ảnh đục
        g = (Graphics2D) image.getGraphics();
        gsm = new GameStateManager();
    }

    //update game
    private void update() {
        gsm.update();
//        Keys.update();
    }

    //draws game
    private void draw() {
        gsm.draw(g);
    }

    //copy buff to screen
    private void drawToScreen() {
        Graphics g2 = getGraphics();
        g2.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
        g2.dispose();//ngat tien trinh
    }

    //ready to display
    public void addNotify() {
        super.addNotify();
        if (thread == null) {
            addKeyListener(this);
            thread = new Thread(this);
            thread.start();
        }
    }

    //key event
    public void keyTyped(KeyEvent key) {

    }

    public void keyPressed(KeyEvent key) {
        Keys.keySet(key.getKeyCode(), true);
    }

    public void keyReleased(KeyEvent key) {

        Keys.keySet(key.getKeyCode(), false);
    }
}
