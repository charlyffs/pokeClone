package com.charlyffs.main;

import java.awt.*;

public class Store extends GameObject {
    
    private boolean collides, newCollides;
    private final int width, height;
    
    public Store(int x, int y, int height, int width) {
        super(ID.Store, x, y);
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void tick() {
        collision();
    }
    
    private void collision() {
        for (GameObject gameObject : handler.objects) {
            if (gameObject.getId() == ID.Player) {
                newCollides = new Rectangle(x, y, width * 32, height * 32).intersects(gameObject.getBounds());
                if (collides != newCollides && newCollides) {
                    System.out.println("Entered store");
                    handler.setUp(false);
                    handler.setDown(false);
                    handler.setLeft(false);
                    handler.setRight(false);
                    GameObserver.openStore();
                }
            }
            collides = newCollides;
        }
    }
    
    @Override
    public void render(Graphics g) {
    }
    
}
