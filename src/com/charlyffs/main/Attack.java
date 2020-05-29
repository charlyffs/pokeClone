package com.charlyffs.main;

class Attack {
    
    private String name;
    private double hp;
    
    Attack(String name) {
        this.name = name;
        hp = 10;
    }
    
    public void setHp(double hp) {
        this.hp = hp;
    }
    
    public double getHp() {
        return hp;
    }
    
    void use(Pokemon source, Pokemon target) {
        double amount = hp * (DataBase.getModifier(source.getType(), target.getType()));
        target.damage(amount);
        target.setCurrentHP(Math.max(target.getCurrentHP(), 0));
        System.out.println(source.getName() + " used " + name + " on " + target.getName() + " for a total damage of: " + amount);
    }
    
    public String getName() {
        return name;
    }
    
}
