package Character.Class;

import Character.AbstractCharacter;
import Character.SkillInterface;
import Character.Skill.*;

class Archer extends AbstractCharacter {
    protected String className = "archer";
    protected SkillInterface[] skills;

    public Archer(String name, String typeName) {
        super(name, typeName);
        this.className = "archer";
        this.skills = new SkillInterface[]{new RapidFire()};
    }
}
