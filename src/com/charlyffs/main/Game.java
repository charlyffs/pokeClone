package com.charlyffs.main;
import javax.print.attribute.HashAttributeSet;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {
    
    //Graphics stuff.
    private final int width = 1280, height = 720;
    private BufferedImage levelArt, geometry;
    private BufferedImageLoader loader;
    private Camera camera;
    
    //Technical stuff.
    private int red, green, blue;
    private Handler handler;
    private boolean running = false;
    
    public static Player player;
    public static String playerName;
    public static int playerGender;
    public static int starterPokemon;
    
    /**
     * Creates the new JFrame, puts the game instance inside of it, instantiates the handler, camera and level.
     * Spawns the player and calls the method to start the thread.
     */
    Game() {
        DataBase.fillTable();
        DataBase.fillPokeDex();
        DataBase.showTable();
        new Window(width, height, "PokeClone", this);
        
        handler = new Handler();
        player = new Player(ID.Player, 400, 200, handler, playerGender, playerName);
        handler.addObject(player);
        try {
            Player.getPokemon().add(DataBase.getPokemon(starterPokemon).clone());
            Player.getPokemon().add(DataBase.getPokemon(0).clone());
            Player.getPokemon().add(DataBase.getPokemon(1).clone());
            Player.getPokemon().add(DataBase.getPokemon(2).clone());
        } catch (Exception e) {
            System.out.println("Clone failed");
            e.printStackTrace();
        }
        System.out.println(player.toString());
        System.out.println(Player.getPokemon().get(0).toString());
        camera = new Camera(0, 0);
        this.addKeyListener(new KeyInput(handler));
        
        loader = new BufferedImageLoader();
        
        geometry = loader.loadImage("/Geo.png");
        levelArt = loader.loadImage("/Art.png");
        
        loadLevel(geometry);
        handler.addObject(new Encounter(456, 356, handler));
    }
    
    /**
     * Kills the game.
     */
    private synchronized void stop() {
        try {
            GameObserver.stopT1();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Contains the game loop (I did not create this, it is one of a few standard ways of coding a game loop),
     * caps fps at 60. Makes the game tick and render constantly.
     */
    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
                frames++;
            }
            
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }
    
    /**
     * Makes the camera and everything else run.
     */
    private void tick() {
        for (GameObject object : handler.objects) {
            if (object.getId() == ID.Player) {
                camera.tick(object);
            }
        }
        handler.tick();
    }
    
    /**
     * Draws the graphics to the screen for every frame.
     */
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        //Initialize bufferStrategy for graphics (if it isn't already)
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        
        //Get graphics from buffer
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;
        
        //Paint background to avoid waterfall effect.
        g.setColor(Color.black);
        g.fillRect(0, 0, 2880, 1620);
        
        //Camera exclusion start (everything in here will stay put)
        g2d.translate(-camera.getX(), -camera.getY());
        
        g.drawImage(levelArt, 0, 0, null);
        handler.render(g);
        
        g2d.translate(camera.getX(), camera.getY());
        //Camera exclusion ends
        
        //Clean up and push the buffer out for output
        g.dispose();
        bs.show();
    }
    
    /**
     * Reads the geometry data from the provided image and creates the corresponding blocks for collision with the user.
     * In the geometry image, red is for borders/obstacles, green is for transition areas, and blue is for encounters.
     * Transition zones and other zones have a custom color code (specific RGB values).
     *
     * @param geo Image containing the level geometry.
     */
    private void loadLevel(BufferedImage geo) {
        int w = geo.getWidth();
        int h = geo.getHeight();
        
        for (int x = 1; x < w; x += 32) {
            for (int y = 1; y < h; y += 32) {
                int pixel = geo.getRGB(x, y);
                red = (pixel >> 16) & 0xff;
                green = (pixel >> 8) & 0xff;
                blue = (pixel) & 0xff;
                if (red == 255) {
                    handler.addObject(new Block(ID.Block, x, y, handler));
                }
            }
        }
        //Transitions between areas
        handler.addObject(new Transition(383, 0, handler, 1104, 560, 2,2));
        handler.addObject(new Transition(1056, 0, handler, 397, 100, 2,4));
        handler.addObject(new Transition(1248, 224, handler, 624, 905, 1,1));
        handler.addObject(new Transition(608, 960, handler, 1247, 258, 1,2));
        handler.addObject(new Transition(992, 543, handler, 214, 947, 1,1));
        handler.addObject(new Transition(192, 992, handler, 1028, 547, 1,2));
        handler.addObject(new PokeCenter(160, 864, handler, 1, 2));
        handler.addObject(new Store(608, 832, handler, 1, 1));
        
    }
    
    private Boolean colorsEqual(int num) {
        return red == num && green == num && blue == num;
    }
    
    public void setRunning(boolean value) {
        running = value;
    }
    
}
