package com.charlyffs.main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class GameObserver extends Application {
    
    private static FXMLLoader loader;
    public static Fight fight;
    public static StoreController store;
    public static Bank bank;
    private static Thread thread1;
    public static Stage stage;
    
    //todo display medals on screen
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        GameObserver.stage = stage;
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        try {
            loader = new FXMLLoader(GameObserver.class.getResource("StartupWindow.fxml"));
            loader.load();
            StartupWindow controller = loader.getController();
            controller.maleSelect();
            controller.bulbasaurSelect();
            switchStage("Main Menu");
        } catch (Exception e) {
            e.printStackTrace();
        }
        stage.show();
    }
    
    //Swaps between fight and store UI
    public static void switchStage(String title) {
        System.out.println("switch stage");
        Platform.runLater(() -> {
            try {
                Parent root = loader.getRoot();
                stage.setScene(new Scene(root));
                stage.setTitle(title);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    
    //On closing main menu, this is called.
    public static void startGame() {
        Game game = new Game();
        thread1 = new Thread(game);
        thread1.setName("Game");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        hideStage();
        game.setRunning(true);
    }
    
    //Switches UI and shows stage
    public static void openStore() {
        System.out.println("Open store running...");
        Platform.runLater(() -> {
            loader = new FXMLLoader(GameObserver.class.getResource("Store.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            store = loader.getController();
            switchStage("Store");
            store.balanceLabel.setText("" + Player.getBalance());
            showStage();
        });
    }
    
    public static void openBank() {
        
        Platform.runLater(() -> {
            loader = new FXMLLoader(GameObserver.class.getResource("Bank.fxml"));
            try {
                loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }
            bank = loader.getController();
            switchStage("Bank");
            bank.updatePreviews();
            showStage();
        });
        
    }
    
    private static Encounter currentEncounter;
    
    static void startFight(int type, boolean gym, Encounter encounter) {
        currentEncounter = encounter;
        if (loader.getController() != fight) {
            loader = new FXMLLoader(GameObserver.class.getResource("Fight.fxml"));
            try {
                loader.load();
            } catch (Exception e) {
                System.out.println("Failed to load");
                e.printStackTrace();
            }
            fight = loader.getController();
            switchStage("Fight");
            System.out.println("Stage switched");
        }
        
        fight.startFight(type, gym);
        showStage();
        
    }
    
    public static void gymBeaten() {
        currentEncounter.setBeaten(true);
    }
    
    private static int x = 400, y = 200;
    
    public static void showStage() {
        System.out.println("Show stage...");
        //FIXME no jala esta ostia me voy a dar un tiro
        Platform.runLater(() -> stage.show());
        x = Game.player.getX();
        y = Game.player.getY();
        thread1.suspend();
    }
    
    public static void hideStage() {
        System.out.println("Hide stage...");
        //FIXME TOGGLE ME TO SEE THE GAME BREAK
//         Platform.runLater(() -> stage.hide());
        thread1.resume();
        Game.player.setX(x);
        Game.player.setY(y);
    }
    
    public static void stopT1() throws InterruptedException {
        thread1.join();
    }
    
}
