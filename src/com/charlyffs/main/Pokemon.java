package com.charlyffs.main;

import java.util.ArrayList;

public class Pokemon implements Cloneable{

    private final ArrayList<Attack> attacks;
    private int hp;
    private final int type;
    private int currentHP, xp, xpCap, level;
    private final String name;
    private Pokemon evolution;
    private boolean participated;
    
    public Pokemon(String name, int hp, int type, String attackName) {
        this.name = name;
        this.hp = hp;
        currentHP = hp;
        level = 1;
        xp = 0;
        xpCap = 100;
        this.type = type;
        attacks = new ArrayList<>();
        attacks.add(new Attack(attackName));
        participated = false;
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
            levelup();
        }
    }
    
    public void levelup() {
        level += 1;
        xpCap += 100;
        hp *= 1.1;
        reset();
    
        if (level == 10) {
            evolve(); //1st
        } else if (level == 20) {
            evolve(); //2nd
        }
    
        System.out.println("Level up\nLevel: " + level + "\nNewCap: " + xpCap );
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
    
    public ArrayList<Attack> getAttacks() {
        return attacks;
    }
    
    public int getHp() {
        return hp;
    }
    
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
    
    public String getURL() {
        return "/Pokemon/" + name + ".png";
    }
    
    @Override
    public String toString() {
        return "Pokemon{" +
                ", moves=" + attacks +
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