package com.charlyffs.main;

import java.awt.*;

/**
 * Pretty much anything in the game world is a GameObject.
 */
public abstract class GameObject {
    
    private ID id;
    int x, y;
    int velX, velY;
    
    Handler handler;
    
    GameObject(ID id, int x, int y, Handler handler) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.handler = handler;
    }
    
    ID getId() {
        return this.id;
    }
    
    /**
     * Get hitbox for collision detection.
     * @return Hitbox.
     */
    Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
    
    public void setId(ID id) {
        this.id = id;
    }
    
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
}
