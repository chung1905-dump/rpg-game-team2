package Gameplay.MapContent;

import java.awt.Image;

public class WaterBlock extends AbstractBlock {
    protected int id = 1;
    protected String blockName = "water";
    protected String img_path = "resources/images/map/block/water.png";

    @Override
    public String getImgPath() {
        return this.img_path;
    }
}
