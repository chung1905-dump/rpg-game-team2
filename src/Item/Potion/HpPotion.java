package Item.Potion;

import Item.AbstractItem;
import Character.CharacterInterface;

public class HpPotion extends AbstractItem {
    protected int regenAmount = 50;
    protected String name = "Hp Potion";
    protected String description = "hoi mau";

    public void execute(CharacterInterface[] targets) {
        targets[0].setHp(targets[0].getHp() + this.regenAmount);
    }
}
