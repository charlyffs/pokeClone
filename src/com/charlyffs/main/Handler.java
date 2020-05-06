package com.charlyffs.main;
import java.awt.*;
import java.util.LinkedList;

public class Handler {
    
    LinkedList<GameObject> objects = new LinkedList<>();
    //Player movement indicators.
    private boolean up = false, down = false, left = false, right = false;
    
    /**
     * Updates all GameObjects' attributes (if they have any).
     */
    void tick() {
        for (GameObject gameObject : objects) {
            gameObject.tick();
        }
    }
    
    /**
     * Redraws all GameObjects' graphics (if they have any).
     * @param g Graphics data.
     */
    void render(Graphics g) {
        for (GameObject gameObject : objects) {
                gameObject.render(g);
        }
        for (GameObject gameObject : objects) {
            if (gameObject.getId() == ID.Player) {
                gameObject.render(g);
            }
        }
    }
    
    void addObject(GameObject gameObject) {
        objects.add(gameObject);
    }
    
    public boolean isUp() {
        return up;
    }
    
    public void setUp(boolean up) {
        this.up = up;
    }
    
    public boolean isDown() {
        return down;
    }
    
    public void setDown(boolean down) {
        this.down = down;
    }
    
    public boolean isLeft() {
        return left;
    }
    
    public void setLeft(boolean left) {
        this.left = left;
    }
    
    public boolean isRight() {
        return right;
    }
    
    public void setRight(boolean right) {
        this.right = right;
    }
}
