package com.charlyffs.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {
    
    private final BufferedImage levelArt;
    private final Camera camera;
    
    private int red, green, blue;
    public static final Handler handler = new Handler();
    private boolean running = false;
    
    public static Player player;
    public static String playerName;
    public static int playerGender;
    public static int starterPokemon;
    
    public static int medals;
    public static Medal medal1, medal2, medal3;
    private Encounter gym1, gym2, gym3;
    
    /**
     * Creates the new JFrame, puts the game instance inside of it, instantiates the handler, camera and level.
     * Spawns the player and calls the method to start the thread.
     */
    Game() {
        DataBase.fillTable();
        DataBase.fillPokeDex();
        new Window(1280, 720, "PokeClone", this);
    
        medal1 = new Medal("/bronze.png", 0);
        medal2 = new Medal("/silver.png", 84);
        medal3 = new Medal("/gold.png", 168);
        handler.addObject(medal1);
        handler.addObject(medal2);
        handler.addObject(medal3);
        
        camera = new Camera(0, 0);
        this.addKeyListener(new KeyInput());
    
        BufferedImageLoader loader = new BufferedImageLoader();
    
        BufferedImage geometry = loader.loadImage("/Geo.png");
        levelArt = loader.loadImage("/Art.png");
        
        loadLevel(geometry);
    
        player = new Player(ID.Player, 400, 200, playerGender, playerName);
        handler.addObject(player);
        Player.getPokemon().add(DataBase.getPokemon(starterPokemon).clone());
    
        Pokemon godPokemon = DataBase.getPokeDex().get(130).clone();
        godPokemon.setHp(9999999);
        godPokemon.getAttacks().get(0).setHp(999999);
        godPokemon.setLevel(99999);
        godPokemon.reset();
        Player.addToBank(godPokemon);
        
    }
    
    /**
     * Kills the game.
     */
    private synchronized void stop() {
        System.out.println("STOP");
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
    
    public static Transition
            storeExit = new Transition(192, 992, 0, 0, 1, 2),
            pokecenterExit = new Transition(608, 960, 0, 0, 1, 2);
    
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
                    handler.addObject(new Block(x, y - 1));
                } else if (colorsEqual(100)) {
                    handler.addObject(new Encounter(x, y, 150, false, 0));
                } else if (colorsEqual(131)) {
                    handler.addObject(new Transition(x, y, 216, 930, 1,1));
                } else if (colorsEqual(141)) {
                    handler.addObject(new Transition(x, y, 631, 900, 1,1));
                }
            }
        }
        
        //Transitions
        //To and from areas
        handler.addObject(new Transition(384, 0, 1296, 1194, 1,2));
        handler.addObject(new Transition(1280, 1248, 402, 34, 1,2));
        handler.addObject(new Transition(1216, 672, 1121, 516, 1,4));
        handler.addObject(new Transition(992, 576, 1265, 706, 1,6));
        handler.addObject(new Transition(801, 320, 2164, 290, 2,1));
        handler.addObject(new Transition(2208, 321, 835, 336, 1,1));
        handler.addObject(new Transition(1056, 0, 2550, 1200, 1, 4));
        handler.addObject(new Transition(640, 1344, 1734, 1040, 2, 1));
        handler.addObject(new Transition(2624, 1152, 1102, 45, 4, 1));
        handler.addObject(new Transition(1696, 1024, 580, 1353, 2, 1));
    
        //To and from gyms.
        handler.addObject(new Transition(192, 1568, 2805, 490, 1, 1));
        handler.addObject(new Transition(2784, 544, 229, 1571, 1, 2));
    
        handler.addObject(new Transition(1856, 576, 2450, 490, 1, 1));
        handler.addObject(new Transition(2432, 544, 1896, 563, 1, 2));
        
        handler.addObject(new Transition(2176, 928, 2788, 195, 1, 1));
        handler.addObject(new Transition(2848, 224, 2179, 964, 1, 2));
        handler.addObject(new Transition(2688, 224, 2179, 964, 1, 2));
        
        handler.addObject(storeExit);
        handler.addObject(pokecenterExit);
        
        handler.addObject(new PokeCenter(160, 864, 1, 2));
        handler.addObject(new Store(608, 832, 1, 1));
        handler.addObject(new bankTrigger(320, 800, 1, 1));
    
        //3 Gym fights
    
        gym1 = new Encounter(2432, 64, 50, true, 30);
        gym2 = new Encounter(2784, 64, 100, true, 10);
        gym3 = new Encounter(2784, 320, 150, true, 20);
        
        handler.addObject(gym1);
        handler.addObject(gym2);
        handler.addObject(gym3);
        
    }
    
    private Boolean colorsEqual(int num) {
        return red == num && green == num && blue == num;
    }
    
    public void setRunning(boolean value) {
        running = value;
    }
    
}
