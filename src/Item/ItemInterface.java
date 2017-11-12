package Item;

import Character.CharacterInterface;

public interface ItemInterface {
    public String getName();
    public String getDescription();
    public void execute(CharacterInterface[] targets);
}