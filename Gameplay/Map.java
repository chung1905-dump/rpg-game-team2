package team2.rpg.Gameplay;

import team2.rpg.Gameplay.MapContent.Block;

public class Map {
    protected int id;
    protected String name;
    protected Block[] content;

    public Block[] getContent() {
        return content;
    }

    public void setContent(Block[] content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
