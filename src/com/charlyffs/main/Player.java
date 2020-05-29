package com.charlyffs.main;
import java.awt.*;
import java.util.ArrayList;

public class Player extends GameObject {
    
    private static ArrayList<Pokemon> pokemon;
    private static ArrayList<Item> inventory;
    private static ArrayList<Pokemon> bank;
    private final String name;
    private final int gender; //0 = male, 1 = female
    private final BufferedImageLoader loader = new BufferedImageLoader();
    private final String path;
    public static int balance;
    public static int immunity;
    
    Player(ID id, int x, int y, int gender, String name) {
        super(id, x, y);
        this.gender = gender;
        this.name = name;
        pokemon = new ArrayList<>();
        inventory = new ArrayList<>();
        bank = new ArrayList<>();
        balance = 50;
        immunity = 0;
        path = gender == 0 ? "/male.png" : "/female.png";
    }
    
    /**
     * Read movement input and collision data. Transform player accordingly.
     */
    public void tick() {
        
        x += velX;
        y += velY;
        collision();
        if (handler.isUp()) velY = -5;
        else if(!handler.isDown()) velY = 0;

        if (handler.isDown()) velY = 5;
        else if(!handler.isUp()) velY = 0;

        if (handler.isRight()) velX = 5;
        else if(!handler.isLeft()) velX = 0;

        if (handler.isLeft()) velX = -5;
        else if(!handler.isRight()) velX = 0;
        
    }
    
    public String getName() {
        return name;
    }
    
    //Distance that will be used for pseudo-raycasting
    private final int range = 4;
    
    //private int width = 31, height = 31;
    /**
     * Casts a rectangle in each direction to detect collisions with other GameObjects.
     */
    
    private Rectangle up, down, left, right;
        
    private void collision() {
        for (GameObject gameObject : handler.objects) {
            if (gameObject.getId() == ID.Block) {
                if (up.intersects(gameObject.getBounds()))
                    handler.setUp(false);
                if (down.intersects(gameObject.getBounds()))
                    handler.setDown(false);
                if (left.intersects(gameObject.getBounds()))
                    handler.setRight(false);
                if (right.intersects(gameObject.getBounds()))
                    handler.setLeft(false);
            }
        }
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y + 16, 32, 32);
    }
    
    /**
     * Draw player to the screen
     * @param g Graphics data
     */
    public void render(Graphics g) {
        up = new Rectangle(x + 6, y - range + 32, 20, range);
        down = new Rectangle(x + 6, y + 50, 20, range);
        left = new Rectangle(x + 32, y + 37, range, 8);
        right = new Rectangle(x - range, y + 37, range, 8);
        
        g.drawImage(loader.loadImage(path), x, y, null);
        
    }
    
    public static ArrayList<Pokemon> getPokemon() {
        return pokemon;
    }
    
    public static ArrayList<Item> getInventory() {
        return inventory;
    }
    
    public static ArrayList<Pokemon> getBank() {
        return bank;
    }
    
    public static int getBalance() {
        return balance;
    }
    
    public static void setBalance(int balance) {
        Player.balance = balance;
    }
    
    public static void addToBank(Pokemon pokemon) {
        bank.add(pokemon);
    }
    
}