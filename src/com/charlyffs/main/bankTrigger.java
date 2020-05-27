package com.charlyffs.main;

import java.awt.*;

public class bankTrigger extends GameObject {
    
    private boolean collides, newCollides;
    private final int width, height;
    
    public bankTrigger(int x, int y, int height, int width) {
        super(ID.Bank, x, y);
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
                    System.out.println("Entered bank");
                    handler.setUp(false);
                    handler.setDown(false);
                    handler.setLeft(false);
                    handler.setRight(false);
                    GameObserver.openBank();
                }
            }
            collides = newCollides;
        }
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.orange);
        g.drawRect(getX(), getY(), width * 32, height * 32);
    }
    
}
