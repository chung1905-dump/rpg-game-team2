package Character;

public interface SkillInterface {
    public String getName();

    public String getDescription();

    public void execute(CharacterInterface caster, CharacterInterface target);
}
