package com.charlyffs.main;

class Attack {
    
    private String name;
    private int hp;
    
    Attack(String name) {
        this.name = name;
        hp = 10;
    }
    
    public void setHp(int hp) {
        this.hp = hp;
    }
    
    void use(Pokemon source, Pokemon target) {
        double amount = (double) source.getLevel() / target.getLevel() * hp * (DataBase.getModifier(source.getType(), target.getType()));
        target.damage(amount);
        System.out.println(source.getName() + " used " + name + " on " + target.getName() + " for a total damage of: " + amount);
    }
    
    public String getName() {
        return name;
    }
    
}
