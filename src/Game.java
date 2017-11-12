
import java.awt.EventQueue;
import javax.swing.JFrame;

public class Game extends JFrame {
    protected int WIDTH = 800;
    protected int HEIGHT = 800;
    protected String TITLE = "RPG";

    protected final int STATUS_RUNNING = 1;
    protected final int STATUS_PAUSE = 2;
    protected int status;

    public Game() {
        init();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Game rpg = new Game();
                rpg.setVisible(true);
            }
        });
    }

    protected void init() {
        add(new Board());
        setSize(this.WIDTH, this.HEIGHT);
        setTitle(this.TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    protected void run() {
    }

    protected void quit() {
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        // @todo: check if status is valid (==1 || ==2)
        this.status = status;
    }
}