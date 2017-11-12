package Gameplay;

import Gameplay.MapContent.*;
import Gameplay.MapData.*;

import java.awt.Image;

public class Map {
    protected AbstractMapData[] allData = new AbstractMapData[]{
            new Map0()
            // put your new maps here
    };
    protected AbstractBlock[] allBlock = new AbstractBlock[]{
            new RockBlock(), //0
            new WaterBlock(), //1
            new GrassBlock() //2
            // put your new blocks here
    };
    protected int id;
    protected String name;
    protected Image[][] content = new Image[10][10];

    public Map(int id) {
        this.id = id;
        this.name = this.allData[id].getName();
    }

    public Image[][] getContent() {
        AbstractMapData currentMap = this.allData[this.id];
        int data[][] = currentMap.getData();
        for (int i = 0; i < currentMap.getWidth(); i++) {
            for (int j = 0; j < currentMap.getHeight(); j++) {
                this.content[i][j] = this.allBlock[data[i][j]].loadImage();
            }
        }
        return this.content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
