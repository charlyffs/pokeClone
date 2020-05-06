package com.charlyffs.main;

class Buff extends Move{
    
    private int subType;
    
    Buff(String name, int hp, int subType) {
        super(name, hp);
        this.subType = subType;
    }
    
    @Override
    void use(Pokemon source, Pokemon target) {
        if (subType == 1) {
            source.heal(hp);
        } else {
            //Lower target's damage
        }
    }
}
