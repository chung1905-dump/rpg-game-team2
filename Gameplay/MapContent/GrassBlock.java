package Gameplay.MapContent;

import java.awt.Image;

public class GrassBlock extends AbstractBlock {
    protected int id = 0;
    protected String blockName = "grass";
    protected String img_path = "/home/magento/java/rpg/out/production/rpg/resources/images/map/block/grass.png";

    @Override
    public String getImgPath() {
        return this.img_path;
    }
}
