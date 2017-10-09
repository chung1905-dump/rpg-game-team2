package Character;

public abstract class AbstractSkill implements SkillInterface {
    protected double skillWeight = 0.01;
    protected String name = "useless skill";
    protected String description = "an example skill";

    /**
     * the weakest skill
     *
     * @param caster
     * @param target
     */
    public void execute(CharacterInterface caster, CharacterInterface target) {
        int casterAp = caster.getAp();
        double hp = target.getHp() - casterAp * this.skillWeight;
        target.setHp((int) hp);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
