package Map;

import java.awt.*;

abstract public class AbstractMap {
    //update function
    abstract public void update();
    //draw map function
    abstract public void draw(Graphics2D g);
    //where player will appear
    abstract public int[] getDefaultPosition();
    //get tile size
    abstract public int getTileWidth();
    abstract public int getTileHeight();

}
