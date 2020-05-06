package com.charlyffs.main;

import java.awt.*;
import java.util.Random;

public class Encounter extends GameObject {
    
    private boolean collides = false, newCollides = false;
    private final Random RNG = new Random();
    
    public Encounter(ID id, int x, int y, Handler handler) {
        super(id, x, y, handler);
    }
    
    @Override
    public void tick() {
        for (GameObject gameObject : handler.objects) {
            if (gameObject.getId() == ID.Player) {
                newCollides = new Rectangle(x, y, 32, 32).intersects(gameObject.getBounds());
                if (collides != newCollides && newCollides) {
                    if (RNG.nextInt(10) >= 1) {
                        handler.setUp(false);
                        handler.setDown(false);
                        handler.setLeft(false);
                        handler.setRight(false);
                        System.out.println("Encounter.");
                        int x = RNG.nextInt(DataBase.getPokeDex().size());
                        GameObserver.startFight(DataBase.getPokemon(x));
                    }
                }
                collides = newCollides;
            }
        }
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(x,y,32,32);
    }
}
