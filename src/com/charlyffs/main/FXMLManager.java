package com.charlyffs.main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLManager extends Application implements Runnable {
    
    private FXMLLoader loader = new FXMLLoader(getClass().getResource("StartupWindow.fxml"));
    public static Stage stage;
    
    @Override
    public void run() {
        Application.launch();
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLManager.stage = stage;
        Parent root = loader.load();
        
        stage.setTitle("Menu");
        Platform.setImplicitExit(false);
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        
        stage.show();
    }
}
