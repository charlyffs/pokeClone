package com.charlyffs.main;

import java.awt.*;
import java.nio.file.FileAlreadyExistsException;

public class Medal extends GameObject {
    
    private boolean isRendering;
    private String url;
    private final BufferedImageLoader loader = new BufferedImageLoader();
    private int shift;
    
    
    public Medal(String url, int shift) {
        super(ID.Medal, 0, 0);
        isRendering = false;
        this.url = url;
        this.shift = shift;
    }
    
    public void setRendering(boolean isRendering) {
        this.isRendering = isRendering;
    }
    
    @Override
    public void tick() {
        x = Game.player.getX() - 625 + shift;
        y = Game.player.getY() + 240;
    }
    
    @Override
    public void render(Graphics g) {
        if (isRendering) {
            g.drawImage(loader.loadImage(url), x, y, null);
        }
    }
}
