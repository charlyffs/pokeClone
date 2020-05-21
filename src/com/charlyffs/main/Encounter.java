package com.charlyffs.main;

import java.awt.*;

public class Encounter extends GameObject {
    
    private boolean collides = false, newCollides = false;
    private final int type;
    private final boolean isGym;
    
    public Encounter(int x, int y, int type, boolean isGym) {
        super(ID.Encounter, x, y);
        this.type = type;
        this.isGym = isGym;
    }
    
    @Override
    public void tick() {
        for (GameObject gameObject : handler.objects) {
            if (gameObject.getId() == ID.Player) {
                newCollides = new Rectangle(x, y, 32, 32).intersects(gameObject.getBounds());
                if (collides != newCollides && newCollides) {
                    if (Player.immunity == 0) {
                        handler.setUp(false);
                        handler.setDown(false);
                        handler.setLeft(false);
                        handler.setRight(false);
                        System.out.println("Encounter.");
                        Player.immunity += 20;
                        GameObserver.startFight(type, isGym);
                    } else {
                        Player.immunity -= 1;
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
