package com.charlyffs.main;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    
    private Handler handler;
    
    public KeyInput() {
        handler = Game.handler;
    }
    
    /**
     * Is player trying to go up, down, left, or right?
     */
    
    public static boolean active = true;
    
    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
        if (active) {
            for (GameObject object : handler.objects) {
                if (object.getId() == ID.Player) {
                    if (key == KeyEvent.VK_W) handler.setUp(true);
                    if (key == KeyEvent.VK_A) handler.setLeft(true);
                    if (key == KeyEvent.VK_S) handler.setDown(true);
                    if (key == KeyEvent.VK_D) handler.setRight(true);
                    if (key == KeyEvent.VK_H) GameObserver.emergency();
                }
            }
        }
    }
    
    /**
     * Is player trying to stop going up, down, left, or right?
     * @param event Key being pressed.
     */
    public void keyReleased(KeyEvent event) {
        int key = event.getKeyCode();
        for (GameObject object : handler.objects) {
            if (object.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) handler.setUp(false);
                if (key == KeyEvent.VK_A) handler.setLeft(false);
                if (key == KeyEvent.VK_S) handler.setDown(false);
                if (key == KeyEvent.VK_D) handler.setRight(false);
            }
        }
    }
    
}
