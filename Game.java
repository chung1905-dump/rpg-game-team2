package team2.rpg;

public class Game {
    protected int WIDTH;
    protected int HEIGHT;
    protected final int STATUS_RUNNING = 1;
    protected final int STATUS_PAUSE = 2;
    protected int status;

    public static void main(String[] args) {
    }

    protected void init() {
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