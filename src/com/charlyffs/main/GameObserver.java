package com.charlyffs.main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public final class GameObserver extends Application {
    
    private static FXMLLoader loader;
    private static Game game;
    public static AnchorPane rootPane;
    private static Thread thread1, thread2;
    public static Fight fight;
    public static volatile boolean flag = false;
    
    public static Stage stage;
    
    //TODO add:
    // pokemon bank. Maximum of 6 in inventory at a time.
    // store
    // pokemon center
    // give money on fights.
    // gym.
    // sort out transitions
    
    public static void main(String[] args) throws IOException {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        GameObserver.stage = stage;
        //Open main menu
        try {
            loader = new FXMLLoader(GameObserver.class.getResource("StartupWindow.fxml"));
            loader.load();
            switchStage("Main Menu");
        } catch (Exception e) {
            e.printStackTrace();
        }
        showStage();
    }
    
    //Swaps between fight and store UI
    public static void switchStage(String title) {
        System.out.println("switch stage");
        Platform.runLater(() -> {
            try {
                Parent root = loader.getRoot();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.setTitle(title);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
    }
    
    //On closing main menu, this is called.
    public static void startGame() {
        game = new Game();
        thread1 = new Thread(game);
        thread1.setName("Game");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
    
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
            switchStage("Store");
        });
    }
    
    static void startFight(Pokemon enemy) {
        showStage();
        System.out.println("Start fight");
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
        fight.startFight(enemy);
        thread1.suspend();
    }
    
    public static void stopFight() {
        hideStage();
        thread1.resume();
    }
    
    private static void showStage() {
        Platform.runLater(() -> stage.show());
    }
    
    
    private static void hideStage() {
//        Platform.runLater(() -> stage.hide());
    }
    
    
    public static void stopT1() throws InterruptedException {
        thread1.join();
    }
    
}
