package com.charlyffs.main;

class Buff extends Move{
    
    private final int subType;
    
    Buff(String name, int hp, int subType) {
        super(name, hp);
        this.subType = subType;
    }
    
    @Override
    void use(Pokemon source, Pokemon target) {
        if (subType == 1) {
            source.heal(hp);
        } else {
            target.damage(10);
        }
    }
}
