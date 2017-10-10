package Gameplay.MapContent;

public class Block {
    protected int id;
    protected String name;
    protected String img_path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgPath() {
        return img_path;
    }

    public void setImgPath(String img_path) {
        this.img_path = img_path;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
