package Gameplay.MapContent;

import java.awt.Image;

public class RockBlock extends AbstractBlock {
    protected int id = 2;
    protected String blockName = "rock";
    protected String img_path = "resources/images/map/block/rock.png";

    @Override
    public String getImgPath() {
        return this.img_path;
    }
}
