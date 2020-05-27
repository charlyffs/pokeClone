package com.charlyffs.main;

import java.util.ArrayList;

public class Pokemon implements Cloneable{

    private final ArrayList<Attack> attacks;
    private int hp;
    private final int type;
    private int currentHP, xp, level;
    private final int nat, xpCap;
    private final String name;
    private boolean canEvolve, hasEvolved;
    private boolean participated;
    
    public Pokemon(int nat, String name, int hp, int type, String attackName, boolean canEvolve) {
        this.name = name;
        this.hp = hp;
        this.canEvolve = canEvolve;
        this.nat = nat;
        hasEvolved = false;
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
    
    public static Pokemon endOfBattle(Pokemon pokemon) {
        pokemon.xp += 100;
        pokemon.participated = false;
        if (pokemon.xp >= pokemon.xpCap) {
            pokemon = levelup(pokemon);
        }
        return pokemon;
    }
    
    public static Pokemon levelup(Pokemon pokemon) {
    
        pokemon.level += 1;
        pokemon.xp = 0;
        pokemon.hp *= 1.1;
    
        if (pokemon.canEvolve) {
            System.out.println(pokemon.name + " evolves!");
            if (pokemon.level == 10 && !pokemon.hasEvolved) {
                pokemon = evolve(pokemon);
                pokemon.hasEvolved = true;
            } else if (pokemon.level == 20) {
                pokemon = evolve(pokemon);
                pokemon.canEvolve = false;
            }
        }
    
        System.out.println("Level up\nLevel: " + pokemon.level + "\nNewCap: " + pokemon.xpCap);
    
        pokemon.reset();
        return pokemon;
    }
    
    private static Pokemon evolve(Pokemon pokemon) {
        int level = pokemon.level;
    
        int index = -1;
        
        for (Pokemon tempPokemon : DataBase.getPokeDex()) {
            if (tempPokemon.getNat() == pokemon.getNat() + 1) {
                index = DataBase.getPokeDex().indexOf(tempPokemon);
            }
        }
    
        pokemon = DataBase.getPokemon(index).clone();
        pokemon.hasEvolved = true;
        for (int i = 0; i < level; i++) {
            pokemon = levelup(pokemon);
        }
    
        return pokemon;
    }
    
    public int getNat() {
        return nat;
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