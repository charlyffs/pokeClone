package com.charlyffs.main;

public class Potion extends Item {
    
    int hp;
    
    public Potion(String name, int hp) {
        super(name);
        this.hp = hp;
    }
    
    @Override
    public boolean use(Pokemon friendly, Pokemon enemy) {
        if (!(friendly.getCurrentHP() + hp > friendly.getHp())) {
            friendly.heal(hp);
            System.out.println("Healed " + hp + " for a total of: " + friendly.getCurrentHP());
            return true;
        }
        return false;
    }
    
    
    
}
