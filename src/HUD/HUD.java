package HUD;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


import Entity.Player;
import Main.GamePanel;
import Manager.Content;

public class HUD {
    private int yOffset;

    private BufferedImage bar;


    private Player player;



    private Font font;
    private Color textColor;

    public HUD(Player p)
    {
        player = p;
       // numMonster = monster1.size();
        yOffset = GamePanel.HEIGHT;

        bar = Content.BAR[0][0];
       // monster = Content.[0][0];
//        boat = Content.ITEMS[0][0];
//        axe = Content.ITEMS[0][1];

        font = new Font("Arial", Font.PLAIN, 10);
        textColor = new Color(47, 64, 126);
    }
    public void draw(Graphics2D g) {

        // draw hud
        g.drawImage(bar, 0, yOffset - 32, null);


    }

}
