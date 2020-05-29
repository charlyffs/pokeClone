package com.charlyffs.main;

import java.util.ArrayList;
import java.util.Random;

public class Pokeball extends Item {
    
    public Pokeball() {
        super("Pokeball");
    }
    
    @Override
    boolean use(Pokemon friendly, Pokemon enemy) {
        ArrayList<Pokemon> pokemon = Player.getPokemon();
        if ((double) enemy.getCurrentHP() / enemy.getHp() <= 0.5) {
            Random rng = new Random();
            if (rng.nextInt(10) > 4) {
                System.out.println("Caught");
                if (pokemon.size() < 5) {
                    System.out.println("Added to belt");
                    pokemon.add(enemy.clone());
                } else {
                    System.out.println("Added to bank");
                    Player.addToBank(enemy.clone());
                }
                enemy.damage(enemy.getCurrentHP());
            }
        } else {
            System.out.println("hp too high");
        }
        return true;
    }
}
