package Character;

public abstract class AbstractCharacter implements CharacterInterface {
    protected final int MOVE_UP = 1;
    protected final int MOVE_RIGHT = 2;
    protected final int MOVE_DOWN = 3;
    protected final int MOVE_LEFT = 4;

    protected int[] currentPosition;

    protected int id;

    protected int exp;
    protected int level;

    protected int ad;
    protected int ap;

    protected int maxHp;
    protected int maxMp;
    protected int hp;
    protected int mp;

    protected SkillInterface[] skills;

    protected String name;
    protected String typeName;
    protected String className;

    public AbstractCharacter(String name, String typeName) {
        this.setName(name);
        this.setTypeName(typeName);
        this.setExp(0);
        this.setLevel(1);
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
        this.setLevel(this.exp2level(exp));
    }

    public void gainExp(int exp) {
        exp += this.getExp();
        this.setExp(exp);
        this.setLevel(this.exp2level(exp));
    }

    protected int exp2level(int exp) {
        // copy from: https://stackoverflow.com/questions/6954874/php-game-formula-to-calculate-a-level-based-on-exp
        return (int) Math.floor(25 + Math.sqrt(625 + 100 * exp)) / 50;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < this.level) {
            //wtf, why level goes down
        }
        // @todo: check max level here, set new maxhp & mp
        this.level = level;
    }

    public int getAd() {
        return ad;
    }

    public void setAd(int ad) {
        this.ad = ad;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp < 0) {
            hp = 0;
        }
        if (hp > this.getMaxMp()) {
            hp = this.getMaxMp();
        }
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        if (mp < 0) {
            mp = 0;
        }
        if (mp > this.getMaxMp()) {
            mp = this.getMaxMp();
        }
        this.mp = mp;
    }

    public SkillInterface[] getSkills() {
        return skills;
    }

    public void learnSkill(SkillInterface skill) {
        // nope. no more skill
    }

    public void setSkills(SkillInterface[] skills) {
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setTypeName(String type) {
        this.typeName = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getId() {
        return this.id;
    }

    public int[] getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int[] currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void move(int a) {
        switch (a) {
            // @todo: move function
            case MOVE_UP:
            case MOVE_RIGHT:
            case MOVE_LEFT:
            case MOVE_DOWN:
            default:
        }
    }

    public void attack(CharacterInterface[] targets) {
        for (int i = 0; i < targets.length; i++) {
            int hp = targets[i].getHp();
            // @todo: armor
            targets[i].setHp(hp - this.getAd());
            if (targets[i].getHp() == 0) {
                // Increase exp by squared of target's level
                this.gainExp(targets[i].getLevel() * targets[i].getLevel());
            }
            // @todo: hpsteal can be done here, use override (for some classes, not all)
        }
    }

    public void useSkill(SkillInterface skill, CharacterInterface[] targets) {
        for (int i = 0; i < targets.length; i++) {
            skill.execute(this, targets[i]);
        }
    }
}