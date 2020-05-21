package com.charlyffs.main;

import java.awt.*;

public class Transition extends GameObject {
    
    private int targetX, targetY;
    private int width, height;
    
    public Transition(int x, int y, int targetX, int targetY, int height, int width) {
        super(ID.Transition, x, y);
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
                    Game.storeExit.setTarget(x + 16, y - 48);
                    Game.pokecenterExit.setTarget(x - 64, y + 16);
                }
            }
        }
    }
    
    public void setTarget(int x, int y) {
        targetX = x;
        targetY = y;
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.drawRect(getX(), getY(), width * 32, height * 32);
    }
}
