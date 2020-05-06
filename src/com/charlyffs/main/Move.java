package com.charlyffs.main;

public abstract class Move {
    
    protected Pokemon source;
    protected String name;
    protected int hp;
    
    public Move(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }
    
    abstract void use(Pokemon source, Pokemon target);
}
