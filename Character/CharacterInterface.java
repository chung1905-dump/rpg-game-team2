package Character;

public interface CharacterInterface {
    public int getId();

    /**
     * Move character
     * - 1 -
     * 4   2
     * - 3 -
     */
    public void move(int a);

    /**
     * Normal attack to target
     */
    public void attack(CharacterInterface[] target);

    /**
     * Cast skill to target(s)
     */
    public void useSkill(SkillInterface skill, CharacterInterface[] targets);

    /**
     * Experience point & level
     */
    public int getExp();

    public int getLevel();

    public void setLevel(int level);

    /**
     * Shortcut to setLevel(1);
     */
    public void levelUp();

    /**
     * HP & MP
     */
    public int getMaxHp();

    public void setMaxHp(int hp);

    public int getHp();

    public void setHp(int hp);

    public int getMaxMp();

    public void setMaxMp(int mp);

    public int getMp();

    public void setMp(int mp);

    /**
     * Names: Chung, Khanh the white, Gandalf the grey,...
     *
     * @return
     */
    public String getName();

    public void setName(String name);

    /**
     * Types: fire, water, lighting, blah blah,...
     *
     * @return
     */
    public String getTypeName();

    public void setTypeName(String name);

    /**
     * Classes: warrior, wizard, blah blah,...
     *
     * @return
     */
    public String getClassName();

    public void setClass(String className);
}
