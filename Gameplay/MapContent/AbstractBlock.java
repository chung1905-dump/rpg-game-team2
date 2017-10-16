package Gameplay.MapContent;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.net.URL;
import java.net.URI;
import java.nio.file.*;

public abstract class AbstractBlock extends JFrame {
    protected int blockW = 80;
    protected int blockH = 80;
    protected int id;
    protected String blockName;
    protected String img_path;
    private static Image img = null;

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

    public String getImg_path() {
        return img_path;
    }

    public static Image getImg() {
        return img;
    }

    public Image loadImage() {
        if (getImg() == null) {
            // @todo: trash code, processing
            URL resource = this.getClass().getResource(this.getImgPath());               //file:/home/magento/java/rpg/out/production/rpg
            Path p = Paths.get(this.getClass().getResource(".").toString()).getParent().getParent();
            Path b = p.toAbsolutePath();
            String c = b.toString();
            ImageIcon i = new ImageIcon(p + "/resources/images/map/block/grass.png"); //file:/home/magento/java/rpg/out/production/rpg/resources/images/map/block/grass.png
            Image a = i.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
            img = i.getImage().getScaledInstance(this.blockW, this.blockH, Image.SCALE_DEFAULT);
        }
        return img;
    }
}