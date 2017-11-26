package Entity.Skill;

import Entity.AbstractCharacter;

import java.awt.*;

abstract public class AbstractSkill {
    abstract public AbstractSkill init(AbstractCharacter entity);

    abstract public void execute(AbstractCharacter entity);

    abstract public void update();

    abstract public void draw(Graphics2D g);

    abstract public boolean isEnd();
}
