package com.charlyffs.main;

import java.util.ArrayList;

public class Pokemon implements Cloneable{

    private final ArrayList<Move> moves;
    private final int hp, type;
    private int currentHP, xp, xpCap, level;
    private final String name;
    private Pokemon evolution;
    private boolean participated;
    
    public Pokemon(int hp, int level, int type, String name) {
        this.hp = hp;
        this.currentHP = hp;
        xp = 0;
        this.xpCap = 100;
        this.level = level;
        this.type = type;
        this.name = name;
        moves = new ArrayList<>();
        participated = false;
    }
    
    public void addMove(int type, int subType, String name, int hp) {
        if (type == 1) {
            moves.add(new Attack(name, hp));
        } else {
            moves.add(new Buff(name, hp, subType));
        }
    }
    
    public Pokemon clone(){
        try {
            return (Pokemon) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void heal(int amount) {
        currentHP += amount;
    }
    
    public void damage(double amount) {
        currentHP -= amount;
    }
    
    public boolean isParticipated() {
        return participated;
    }
    
    public void setParticipated(boolean participated) {
        this.participated = participated;
    }
    
    public void endOfBattle() {
        xp += 50;
        participated = false;
        if (xp >= xpCap) {
            level += 1;
            xpCap += 100;
            System.out.println("Level up\nLevel: " + level + "\nNewCap: " + xpCap );
            //todo check evolution
        }
    }
    
    private void evolve() {
        //todo Turn this pokemon into evolution
        //name = evolution.getName();
        //change sprites, moves maybe?
        //replace pokemon in belt with clone from database, set level and hp to be equal.
    }
    
    public void reset() {
        currentHP = hp;
    }
    
    public int getCurrentHP() {
        return currentHP;
    }
    
    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }
    
    public int getType() {
        return type;
    }
    
    public String getName() {
        return name;
    }
    
    public ArrayList<Move> getMoves() {
        return moves;
    }
    
    public int getHp() {
        return hp;
    }
    
    public int getLevel() {
        return level;
    }
    
    public String getURL() {
        return "/Pokemon/" + name + ".png";
    }
    
    @Override
    public String toString() {
        return "Pokemon{" +
                ", moves=" + moves +
                ", hp=" + hp +
                ", type=" + type +
                ", currentHP=" + currentHP +
                ", xp=" + xp +
                ", xpCap=" + xpCap +
                ", level=" + level +
                ", name='" + name + '\'' +
                '}';
    }
}