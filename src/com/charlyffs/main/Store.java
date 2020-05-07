package com.charlyffs.main;

import java.awt.*;

public class Store extends GameObject {
    
    private boolean collides, newCollides;
    private int width, height;
    
    public Store(int x, int y, Handler handler, int height, int width) {
        super(ID.Store, x, y, handler);
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
                }
            }
            collides = newCollides;
        }
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.drawRect(getX(), getY(), width * 32, height * 32);
    }
    
}