package Character.Skill;

import Character.AbstractSkill;
import Character.CharacterInterface;

public class RapidFire extends AbstractSkill {
    private double skillWeight = 2;
    protected String name = "Rapid Fire";
    protected String description = "Ban bum bum chiu chiu, double damage, character he lua thi x3 damage, phe vl ra ma chi danh cho class archer thoi";

    public void execute(CharacterInterface caster, CharacterInterface target) {
        if (caster.getClassName() == "archer") {
            if (caster.getTypeName() == "fire") {
                this.skillWeight = 3;
            }
            super.execute(caster, target);
        }
    }
}
