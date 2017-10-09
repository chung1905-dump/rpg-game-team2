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
     * currentPosition[0] = x;
     * currentPosition[1] = y;
     *
     * @return
     */
    public int[] getCurrentPosition();

    public void setCurrentPosition(int[] currentPosition);

    /**
     * Ability Power. Attack Damage
     *
     * @return
     */
    public int getAd();

    public void setAd(int ad);

    public int getAp();

    public void setAp(int ap);


    /**
     * Normal attack to target(s)
     */
    public void attack(CharacterInterface[] targets);

    /**
     * Get all learned skill
     * @return
     */
    public SkillInterface[] getSkills();

    /**
     * @notice: Temporary not available
     * @param skill
     */
    public void learnSkill(SkillInterface skill);

    /**
     * Cast skill to target(s)
     */
    public void useSkill(SkillInterface skill, CharacterInterface[] targets);

    /**
     * Experience point & level
     */
    public int getExp();

    // Add an amount of exp
    public void gainExp(int exp);

    public int getLevel();

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

    /**
     * Types: fire, water, lighting, blah blah,...
     *
     * @return
     */
    public String getTypeName();

    /**
     * Classes: warrior, wizard, blah blah,...
     *
     * @return
     */
    public String getClassName();
}