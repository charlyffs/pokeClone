package com.charlyffs.main;

import java.awt.*;

public class PokeCenter extends GameObject {
    
    private boolean collides, newCollides;
    private final int width, height;
    
    public PokeCenter(int x, int y, int height, int width) {
        super(ID.PokeCenter, x, y);
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
                    for (Pokemon pokemon : Player.getPokemon()) {
                        pokemon.reset();
                    }
                    System.out.println("Pokemon healed");
                    }
                }
            collides = newCollides;
        }
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.drawRect(getX(), getY(), width * 32, height * 32);
    }
    
}
