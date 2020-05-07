package com.charlyffs.main;

public final class GameObserver {
    
    private Game game;
    private static Thread thread1, thread2;
    public static Fight fight;
    public static volatile boolean flag = false;
    
    //TODO add:
    // pokemon bank. Maximum of 6 in inventory at a time.
    // store
    // pokemon center
    // give money on fights.
    // gym.
    // sort out transitions
    
    public static void main(String[] args) {
        new GameObserver();
    }
    
    public GameObserver() {
        thread2 = new Thread(new FXMLManager());
        thread2.start();
        thread2.setName("UI");
    
        while (!flag) {
            //todo careful
            Thread.onSpinWait();
        }
        
        game = new Game();
        thread1 = new Thread(game);
        thread1.setName("Game");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
    
        game.setRunning(true);
        
    }
    
    static void startFight(Pokemon enemy) {
        System.out.println("Start fight");
        fight.startFight(Game.player, enemy);
        thread1.suspend();
    }
    
    public static void stopFight() {
        thread1.resume();
    }
    
    public static void stopT1() throws InterruptedException {
        thread1.join();
    }
    
}
