package com.charlyffs.main;

import java.awt.*;

public class Encounter extends GameObject {
    
    private boolean collides = false;
    private final int type;
    private final boolean isGym;
    private boolean isBeaten;
    
    public Encounter(int x, int y, int type, boolean isGym) {
        super(ID.Encounter, x, y);
        this.type = type;
        this.isGym = isGym;
        isBeaten = false;
    }
    
    @Override
    public void tick() {
        for (GameObject gameObject : handler.objects) {
            if (gameObject.getId() == ID.Player) {
                boolean newCollides = new Rectangle(x, y, 32, 32).intersects(gameObject.getBounds());
                if (collides != newCollides && newCollides) {
                    boolean alive = false;
                    for (Pokemon pokemon : Player.getPokemon()) {
                        if (pokemon.getCurrentHP() > 0) {
                            alive = true;
                        }
                    }
                    if (alive && (Player.immunity < 1 || (isGym && !isBeaten)) && !(Player.getPokemon().size() == 0)) {
                        handler.setUp(false);
                        handler.setDown(false);
                        handler.setLeft(false);
                        handler.setRight(false);
                        System.out.println("Encounter.");
                        Player.immunity = 20;
                        GameObserver.startFight(type, isGym, this);
                    } else {
                        Player.immunity -= 1;
                    }
                }
                collides = newCollides;
            }
        }
    }
    
    public void setBeaten(boolean beaten) {
        isBeaten = beaten;
    }
    
    @Override
    public void render(Graphics g) {
    
    }
    
}
