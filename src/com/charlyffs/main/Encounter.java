package com.charlyffs.main;

import java.awt.*;

public class Encounter extends GameObject {
    
    private boolean collides = false, newCollides = false;
    private final int type;
    private final boolean isGym;
    
    public Encounter(int x, int y, int type, Handler handler, boolean isGym) {
        super(ID.Encounter, x, y, handler);
        this.type = type;
        this.isGym = isGym;
    }
    
    @Override
    public void tick() {
        for (GameObject gameObject : handler.objects) {
            if (gameObject.getId() == ID.Player) {
                newCollides = new Rectangle(x, y, 32, 32).intersects(gameObject.getBounds());
                if (collides != newCollides && newCollides) {
                    handler.setUp(false);
                    handler.setDown(false);
                    handler.setLeft(false);
                    handler.setRight(false);
                    System.out.println("Encounter.");
                    GameObserver.startFight(type, isGym);
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
