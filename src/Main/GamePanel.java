package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import Manager.*;
import Tool.Keys;

public class GamePanel extends JPanel implements Runnable, KeyListener {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;

    private final int FPS = 30;
    private final long TARGET_TIME = 1000 / FPS; // target time in milisecond

    private Thread thread;
    private BufferedImage i;
    public Graphics2D g;

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
            start = System.nanoTime(); //start time in nanosecond

            update();
            draw();

            elapsed = (System.nanoTime() - start) / 1000000; //elapsed time in milisecond
            wait = TARGET_TIME - elapsed; //waittime in milisecond
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

    private void init() {
        i = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) i.getGraphics();
        gsm = new GameStateManager();
    }

    private void update() {
        gsm.getCurrent().update();
    }

    private void draw() {
        gsm.getCurrent().draw(g);
        Graphics g2 = this.getGraphics();
        g2.drawImage(i, 0, 0, WIDTH, HEIGHT, null);
        g2.dispose();
    }

    // ready to display
    public void addNotify() {
        super.addNotify();
        if (thread == null) {
            addKeyListener(this);
            thread = new Thread(this);
            thread.start();
        }
    }

    public void keyTyped(KeyEvent key) {
    }

    public void keyPressed(KeyEvent key) {
        Keys.keySet(key.getKeyCode(), true);
    }

    public void keyReleased(KeyEvent key) {
        Keys.keySet(key.getKeyCode(), false);
    }

}
