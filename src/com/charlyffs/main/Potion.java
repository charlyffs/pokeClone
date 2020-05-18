package com.charlyffs.main;

public class Potion extends Item {
    
    int hp;
    
    public Potion(String name, int hp) {
        super(name);
        this.hp = hp;
    }
    
    @Override
    public boolean use(Pokemon friendly, Pokemon enemy) {
        if (!(friendly.getCurrentHP() == friendly.getHp())) {
            friendly.heal(hp);
    
            int friendlyCurrentHP = friendly.getCurrentHP();
            int friendlyHp = friendly.getHp();
            
            //Shave off excedent health points, if there are
            friendly.setCurrentHP(Math.min(friendlyCurrentHP, friendlyHp));
            
            System.out.println("Healed " + hp + " for a total of: " + friendly.getCurrentHP());
            return true;
        }
        return false;
    }
    
}
