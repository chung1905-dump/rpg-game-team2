import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.net.URL;

import Gameplay.Map;

public class Board extends JPanel {
    protected Map map;
    private Image content[][];

    public Board() {
        this.initBoard();
    }

    private void initBoard() {
        this.map = new Map(0);
        this.content = this.map.getContent();
//        int w = this.grass.getWidth(this);
//        int h = this.grass.getHeight(this);
//        setPreferredSize(new Dimension(w, h));
    }

    public void paintComponent(Graphics g) {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                g.drawImage(content[y][x], x * 80, y * 80, null);
            }
        }
    }
}
