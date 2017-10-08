package Character;

public abstract class AbstractCharacter implements CharacterInterface {
    protected final int MOVE_UP = 1;
    protected final int MOVE_RIGHT = 2;
    protected final int MOVE_DOWN = 3;
    protected final int MOVE_LEFT = 4;

    int hp;
    int mp;
    // int dmg;
    int def;
    int speed;
    String img_path;
    int id;
//    Skill a;

    void attack() {
    }

    void useSkillQ() {
    }

    void useSkillW() {
    }

    public void move(int a) {
        switch (a) {
            // @todo: moveup function
            case MOVE_UP:
            case MOVE_RIGHT:
            case MOVE_LEFT:
            case MOVE_DOWN:
            default:
        }
    }

    void unlockSkill() {
    }
}