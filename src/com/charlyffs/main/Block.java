package com.charlyffs.main;
import java.awt.*;

public class Block extends GameObject {
    
    Block(ID id, int x, int y, Handler handler) {
        super(id, x, y, handler);
    }
    
    @Override
    public void tick() {
    
    }
    
    @Override
    public void render(Graphics g) {
        //todo remove, debugging purposes
        g.setColor(Color.green);
        g.drawRect(getX(), getY(), 32 , 32);
    }
}
