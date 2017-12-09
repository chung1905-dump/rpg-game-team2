package Main;


import Manager.GameStateManager;
import Tool.Keys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable, KeyListener {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    public static final int FPS = 30; // can't change it now
    private static final long TARGET_TIME = 1000 / FPS; // target time in milliseconds
    private static GamePanel instance;
    public Graphics2D g;
    private Thread thread;
    private BufferedImage i;
    //game state manager
    private GameStateManager gsm;

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

        while (true) {
            start = System.currentTimeMillis(); //start time in milliseconds

            update();
            draw();
            drawToScreen();

            elapsed = System.currentTimeMillis() - start; //elapsed time in milliseconds
            wait = TARGET_TIME - elapsed; //wait time in milliseconds
            if (wait < 0) {
                wait = TARGET_TIME;
            }

            try {
                Thread.sleep(wait);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //initializes fields
    private void init() {
        i = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) i.getGraphics();
        gsm = GameStateManager.getInstance();
    }

    //update game
    private void update() {
        gsm.update();
        Keys.update();
    }

    //draws game
    private void draw() {
        gsm.draw(g);
    }

    //copy buff to screen
    private void drawToScreen() {
        Graphics g2 = getGraphics();
        g2.drawImage(i, 0, 0, WIDTH, HEIGHT, null);
        g2.dispose();
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
