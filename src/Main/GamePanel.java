package Main;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;

public class GamePanel extends JPanel implements Runnable {
    public void run() {

    }

    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;

    public GamePanel() {
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Java 2D!", 300, 220);
    }
}
