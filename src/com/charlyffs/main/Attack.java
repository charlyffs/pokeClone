package com.charlyffs.main;

class Attack extends Move{
    
    Attack(String name, int hp) {
        super(name, hp);
    }
    
    @Override
    void use(Pokemon source, Pokemon target) {
        double amount = (double) source.getLevel() / target.getLevel() * hp * (DataBase.getModifier(source.getType(), target.getType()));
        target.damage(amount);
        System.out.println(source.getName() + " used " + name + " on " + target.getName() + " for a total damage of: " + amount);
    }
    
}
