package com.charlyffs.main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public final class GameObserver extends Application {
    
    private static FXMLLoader loader;
    public static Fight fight;
    public static StoreController store;
    public static Bank bank;
    private static Thread thread1;
    public static volatile boolean flag = false;
    public static Stage stage;
    
    //TODO add:
    // pokemon bank. Maximum of 6 in inventory at a time.
    // store
    // pokemon center
    // give money on fights.
    // gym.
    // sort out transitions
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
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
    
    private static boolean once = false;
    
    //Swaps between fight and store UI
    public static void switchStage(String title) {
        System.out.println("switch stage");
        Platform.runLater(() -> {
            try {
                Parent root = loader.getRoot();
                stage.setScene(new Scene(root));
                stage.setTitle(title);
                if (!once) {
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.setResizable(false);
                    once = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            stage.show();
        });
        
    }
    
    //On closing main menu, this is called.
    public static void startGame() {
    
        Game game = new Game();
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
            store = loader.getController();
            switchStage("Store");
            store.balanceLabel.setText("" + Player.getBalance());
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
        });
        
    }
    
    static void startFight(int type, boolean gym) {
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
        thread1.suspend();
    }
    
    public static void backToGame() {
        hideStage();
        thread1.resume();
    }
    
    public static void showStage() {
        System.out.println("Show stage...");
//        Platform.runLater(() -> stage.toFront());
    }
    
    public static void hideStage() {
        System.out.println("Hide stage...");
//        Platform.runLater(() -> stage.toBack());
    }
    
    public static void stopT1() throws InterruptedException {
        thread1.join();
    }
    
}
