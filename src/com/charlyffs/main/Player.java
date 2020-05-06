package com.charlyffs.main;
import javax.naming.Name;
import java.awt.*;
import java.util.ArrayList;

public class Player extends GameObject {
    
    private static ArrayList<Pokemon> pokemon;
    private static ArrayList<Item> inventory;
    private String name;
    private int gender; //0 = male, 1 = female
    private BufferedImageLoader loader = new BufferedImageLoader();
    private String path;
    
    Player(ID id, int x, int y, Handler handler, int range, int gender, String name) {
        super(id, x, y, handler);
        this.range = range;
        this.gender = gender;
        this.name = name;
        pokemon = new ArrayList<>();
        inventory = new ArrayList<>();
    
        for (int i = 0; i < 10; i++) {
            inventory.add(new Potion("Healing potion", 50));
            inventory.add(new Pokeball("Pokeball"));
        }
        
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
    private final int range;
    
    //private int width = 31, height = 31;
    /**
     * Casts a rectangle in each direction to detect collisions with other GameObjects.
     */
    private void collision() {
        for (GameObject gameObject : handler.objects) {
            if (gameObject.getId() == ID.Block) {
                if (new Rectangle(x, y - range, 32, range).intersects(gameObject.getBounds()))
                    handler.setUp(false);
                if (new Rectangle(x, y + 48, 32, range).intersects(gameObject.getBounds()))
                    handler.setDown(false);
                if (new Rectangle(x + 32, y, range, 48).intersects(gameObject.getBounds()))
                    handler.setRight(false);
                if (new Rectangle(x - range, y, range, 48).intersects(gameObject.getBounds()))
                    handler.setLeft(false);
            }
        }
    }
    
    /**
     * Draw player to the screen
     * @param g Graphics data
     */
    public void render(Graphics g) {
        g.drawImage(loader.loadImage(path), x, y, null);
        //todo remove debug raycast boxes
        g.drawRect(x, y - range, 32, range);
        g.drawRect(x, y + 48, 32, range);
        g.drawRect(x + 32, y, range, 48);
        g.drawRect(x - range, y, range, 48);
    }
    
    public static ArrayList<Pokemon> getPokemon() {
        return pokemon;
    }
    
    public static ArrayList<Item> getInventory() {
        return inventory;
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
}