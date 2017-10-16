package Gameplay.MapContent;

import javax.swing.*;
import java.awt.Image;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WaterBlock extends AbstractBlock {
    private static Image WaterImage = null;

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public String getBlockName() {
        return "Water";
    }

    public Image getImg() {
        return WaterImage;
    }
    public void setImg(Image img) {
        WaterImage = img;
    }


    @Override
    public String getImgPath() {
        return "resources/images/map/block/water.png";
    }
    public Image loadImage() {
        if (this.getImg() == null) {
            Path p = Paths.get(this.getClass().getResource("").toString()).getParent().getParent();
            String c = p.normalize().toString();
            if (p.startsWith("file:")) {
                c = c.substring(5);
            }
            ImageIcon i = new ImageIcon(c + "/" + this.getImgPath()); //file:/home/magento/java/rpg/out/production/rpg/resources/images/map/block/grass.png
            this.setImg(i.getImage());
        }
        return this.getImg();
    }

}
