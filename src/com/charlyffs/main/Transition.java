package com.charlyffs.main;

import java.awt.*;

public class Transition extends GameObject {
    
    private final int targetX, targetY;
    private final int width, height;
    
    public Transition(int x, int y, Handler handler, int targetX, int targetY, int height, int width) {
        super(ID.Transition, x, y, handler);
        this.targetX = targetX;
        this.targetY = targetY;
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
                if (new Rectangle(x, y, width * 32, height * 32).intersects(gameObject.getBounds())) {
                    gameObject.setX(targetX);
                    gameObject.setY(targetY);
                }
            }
        }
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.drawRect(getX(), getY(), width * 32, height * 32);
    }
}
