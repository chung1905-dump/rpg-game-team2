package Manager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Content{
   // public static BufferedImage[][] TITLE= load();
    public static BufferedImage[][] MENUBG = load("/images/HUD/poster.png", 800, 800);
    public static BufferedImage[][] DIAMOND = load("/images/HUD/fire1.gif", 80, 80);
    public static BufferedImage[][] PLAYER = load("/images/sprites/playersprites.gif", 16, 16);
    public static BufferedImage[][] font = load("/images/HUD/font.gif", 8, 8);

    public static BufferedImage[][] load(String s,int w,int h){
        BufferedImage[][] ret;
        try{
            BufferedImage spritesheet = ImageIO.read(Content.class.getResourceAsStream(s));
            int width = spritesheet.getWidth() / w;
            int height = spritesheet.getHeight() / h;
            ret = new BufferedImage[height][width];
            for (int i = 0; i < height ;i++){
                for(int j = 0; j < width ;j++){
                    ret[i][j] = spritesheet.getSubimage(j * w,i * h, w, h);
                }
            }
            return ret;
        }catch (Exception e){
            e.printStackTrace();
            System.out.print("Error loading graphics");
            System.exit(0);
        }
        return null;
    }
    public static void drawString(Graphics2D g ,String s,int x ,int y){
        s = s.toUpperCase();
        for( int i=0 ;i < s.length() ; i++ ){
            char c = s.charAt(i);
            if( c == 47 ) c = 36;
            if( c == 58 ) c = 37;
            if( c == 32 ) c = 38;
            if( c >= 65 && c <=90) c -= 65;
            if( c >= 48 && c <=57) c -= 22;
            int row = c / font[0].length;
            int col = c % font[0].length;
            g.drawImage(font[row][col],x + 24 * i,y,24,24,null);
        }
    }
}