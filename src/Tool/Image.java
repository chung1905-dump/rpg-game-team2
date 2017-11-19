package Tool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public final class Image {
    //load img
    public static BufferedImage loadImage(String imgPath) {
        try {
            return ImageIO.read(Image.class.getResourceAsStream(imgPath));
        } catch (Exception e) {
            System.out.println("Error loading graphics.");
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    //load a part of img (x,y,w,h)
    public static BufferedImage loadImage(String imgPath, int x, int y, int width, int height) {
        try {
            BufferedImage origImage = ImageIO.read(Image.class.getResourceAsStream(imgPath));
            return origImage.getSubimage(x, y, width, height);
        } catch (Exception e) {
            System.out.println("Error loading graphics.");
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }
}
