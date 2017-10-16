package Gameplay.MapContent;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.net.URL;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class AbstractBlock extends JFrame {
    protected int blockW = 80;
    protected int blockH = 80;
    protected int id;
    protected String blockName;
    protected String img_path;
    protected static Image img = null;

    public String getBlockName() {
        return blockName;
    }

    public String getImgPath() {
        return img_path;
    }

    public int getId() {
        return id;
    }

    public int getBlockW() {
        return blockW;
    }

    public int getBlockH() {
        return blockH;
    }

    public abstract Image getImg();


    public abstract Image loadImage();
}