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
            Audio.playFile("/Audio/TitleScreen.mp3");
            switchStage("Main Menu");
        } catch (Exception e) {
            e.printStackTrace();
        }
        stage.show();
    }
    
    //Swaps between fight and store UI
    public static void switchStage(String title) {
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
        Audio.playFile("/Audio/Ambient.mp3");
        Game game = new Game();
        thread1 = new Thread(game);
        thread1.setName("Game");
        thread1.setPriority(Thread.MAX_PRIORITY);
        game.setRunning(true);
        thread1.start();
        hideStage();
    }
    
    //Switches UI and shows stage
    public static void openStore() {
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
    
    static void startFight(int type, boolean gym, Encounter encounter, int z) {
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
        }
        fight.startFight(type, gym, z);
        showStage();
    }
    
    public static void gymBeaten() {
        currentEncounter.setBeaten(true);
    }
    
    
    public static void showStage() {
        KeyInput.active = false;
        //FIXME no jala esta ostia me voy a dar un tiro
        Platform.runLater(() -> {
            stage.toFront();
//            stage.show();
        });
        Game.player.velX = 0;
        Game.player.velY = 0;
    }
    
    public static void hideStage() {
        KeyInput.active = true;
        
        //FIXME TOGGLE ME TO SEE THE GAME BREAK
        Platform.runLater(() -> {
//            stage.hide();
            stage.toBack();
        });
        
        Audio.playFile("/Audio/Ambient.mp3");
    }
    
    public static void stopT1() throws InterruptedException {
        thread1.join();
    }
    
    public static void emergency() {
        Game.player.x = 400;
        Game.player.y = 200;
    }
    
}
