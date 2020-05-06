package com.charlyffs.main;

public abstract class Item {
    
    private String name;
    
    public Item(String name) {
        this.name = name;
    }
    
    abstract boolean use(Pokemon friendly, Pokemon enemy);
    
    public String getName() {
        return name;
    }
    
}
