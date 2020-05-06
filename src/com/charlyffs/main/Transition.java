package com.charlyffs.main;

import java.awt.*;

public class Transition extends GameObject {
    
    private int targetX, targetY;
    
    public Transition(ID id, int x, int y, Handler handler, int targetX, int targetY) {
        super(id, x, y, handler);
        this.targetX = targetX;
        this.targetY = targetY;
    }
    
    @Override
    public void tick() {
    collision();
    }
    
    private void collision() {
        for (GameObject gameObject : handler.objects) {
            if (gameObject.getId() == ID.Player) {
                if (new Rectangle(x, y, 32, 32).intersects(gameObject.getBounds())) {
                    gameObject.setX(targetX);
                    gameObject.setY(targetY);
                }
            }
        }
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.drawRect(getX(), getY(), 32, 32);
    }
}
