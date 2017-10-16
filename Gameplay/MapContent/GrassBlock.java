package Gameplay.MapContent;

import javax.swing.*;
import java.awt.Image;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GrassBlock extends AbstractBlock {
    private static Image GrassImage = null;

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getBlockName() {
        return "Grass";
    }

    public Image getImg() {
        return GrassImage;
    }

    public void setImg(Image img) {
        GrassImage = img;
    }

    @Override
    public String getImgPath() {
        return "resources/images/map/block/grass.png";
    }

    public Image loadImage() {
        if (this.getImg() == null) {
            Path p = Paths.get(this.getClass().getResource("").toString()).getParent().getParent();
            String c = p.normalize().toString();
            if (p.startsWith("file:")) {
                c = c.substring(5);
            }
            ImageIcon i = new ImageIcon(c + "/" + this.getImgPath()); //file:/home/magento/java/rpg/out/production/rpg/resources/images/map/block/grass.png
            this.setImg(i.getImage().getScaledInstance(this.blockW, this.blockH, Image.SCALE_DEFAULT));
        }
        return this.getImg();
    }

}
