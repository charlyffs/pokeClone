package com.charlyffs.main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class StartupWindow {
    
    public TextField nameField;
    public RadioButton bulbasaurRadio, charmanderRadio, squirtleRadio, maleRadio, femaleRadio;
    public ImageView playerPicture;
    public ImageView pokemonPicture;
    private String name;
    private int gender, pokemonIndex;
    
    public void bulbasaurSelect(ActionEvent actionEvent) {
        pokemonIndex = 0;
        charmanderRadio.setSelected(false);
        squirtleRadio.setSelected(false);
        pokemonPicture.setImage(new Image("/Pokemon/Bulbasaur/Bulbasaur.png"));
    }
    
    public void charmanderSelect(ActionEvent actionEvent) {
        pokemonIndex = 1;
        bulbasaurRadio.setSelected(false);
        squirtleRadio.setSelected(false);
        pokemonPicture.setImage(new Image("/Pokemon/Charmander/Charmander.png"));
    }
    
    public void squirtleSelect(ActionEvent actionEvent) {
        pokemonIndex = 2;
        charmanderRadio.setSelected(false);
        bulbasaurRadio.setSelected(false);
        pokemonPicture.setImage(new Image("/Pokemon/Squirtle/Squirtle.png"));
    }
    
    public void startClicked() throws IOException {
        Game.starterPokemon = bulbasaurRadio.isSelected() ? 0 : charmanderRadio.isSelected() ? 1 : squirtleRadio.isSelected() ? 2 : 0;
        Game.playerName = nameField.getText();
        Game.playerGender = gender;
        GameObserver.flag = true;
    
//        GameObserver.stage.hide();
        GameObserver.startGame();
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("Fight.fxml"));
//

//
//        GameObserver.fight = loader.getController();

//
//        FXMLManager.stage.setHeight(323);
//        FXMLManager.stage.setWidth(524);
    }
    
    public void maleSelect(ActionEvent actionEvent) {
        femaleRadio.setSelected(false);
        playerPicture.setImage(new Image("/male.png"));
        gender = 0;
    }
    
    public void femaleSelect(ActionEvent actionEvent) {
        maleRadio.setSelected(false);
        playerPicture.setImage(new Image("/female.png"));
        gender = 1;
    }
}
