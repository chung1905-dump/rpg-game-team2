import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.net.URL;

public class Board extends JPanel {

    private Image grass;
    private Image water;
    private Image rock;

    public Board() {
        this.initBoard();
    }

    private void initBoard() {
        this.loadImage();
        int w = this.grass.getWidth(this);
        int h = this.grass.getHeight(this);
        setPreferredSize(new Dimension(w, h));
    }

    private void loadImage() {
        URL grassResouce = this.getClass().getResource("resources/images/map/block/grass.png");
        ImageIcon ii = new ImageIcon(grassResouce);
        this.grass = ii.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);

        URL waterResource = this.getClass().getResource("resources/images/map/block/water.png");
        ImageIcon iii = new ImageIcon(waterResource);
        this.water = iii.getImage();

        URL rockResource = this.getClass().getResource("resources/images/map/block/rock.png");
        ImageIcon iiii = new ImageIcon(rockResource);
        this.rock = iiii.getImage();

    }

    public void paintComponent(Graphics g) {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                if (x == 9 || y == 0 || y == 9) {
                    g.drawImage(this.rock, x * 80, y * 80, null);
                } else if ((x == 4 && y == 4) || (x == 4 && y == 5) || (x == 5 && y == 4) || (x == 5 && y == 5) || (x == 3 && y == 2)) {
                    g.drawImage(this.water, x * 80, y * 80, null);
                } else {
                    g.drawImage(this.grass, x * 80, y * 80, null);
                }
            }
        }
    }
}
