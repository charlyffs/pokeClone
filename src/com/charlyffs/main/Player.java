package com.charlyffs.main;
import javax.naming.Name;
import java.awt.*;
import java.util.ArrayList;

public class Player extends GameObject {
    
    private static ArrayList<Pokemon> pokemon;
    private static ArrayList<Item> inventory;
    private static ArrayList<Pokemon> bank;
    private String name;
    private int gender; //0 = male, 1 = female
    private BufferedImageLoader loader = new BufferedImageLoader();
    private String path;
    public static int balance;
    
    Player(ID id, int x, int y, Handler handler, int gender, String name) {
        super(id, x, y, handler);
        this.gender = gender;
        this.name = name;
        pokemon = new ArrayList<>();
        inventory = new ArrayList<>();
        bank = new ArrayList<>();
        balance = 100;
    
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
        //todo remove debug raycast boxes
        g.drawRect((int) up.getX(), (int) up.getY(), (int) up.getWidth(), (int) up.getHeight());
        g.drawRect((int) down.getX(), (int) down.getY(), (int) down.getWidth(), (int) down.getHeight());
        g.drawRect((int) left.getX(), (int) left.getY(), (int) left.getWidth(), (int) left.getHeight());
        g.drawRect((int) right.getX(), (int) right.getY(), (int) right.getWidth(), (int) right.getHeight());
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
    
    @Override
    public String toString() {
        return "Player{" +
                "pokemon=" + pokemon +
//                ", inventory=" + inventory +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", range=" + range +
                '}';
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