package com.charlyffs.main;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StartupWindow {
    
    public TextField nameField;
    public RadioButton bulbasaurRadio, charmanderRadio, squirtleRadio, maleRadio, femaleRadio;
    public ImageView playerPicture;
    public ImageView pokemonPicture;
    private int gender = 0;
    
    public void bulbasaurSelect() {
        bulbasaurRadio.setDisable(true);
        charmanderRadio.setDisable(false);
        squirtleRadio.setDisable(false);
        charmanderRadio.setSelected(false);
        squirtleRadio.setSelected(false);
        pokemonPicture.setImage(new Image("/Pokemon/Bulbasaur.png"));
    }
    
    public void charmanderSelect() {
        charmanderRadio.setDisable(true);
        bulbasaurRadio.setDisable(false);
        squirtleRadio.setDisable(false);
        bulbasaurRadio.setSelected(false);
        squirtleRadio.setSelected(false);
        pokemonPicture.setImage(new Image("/Pokemon/Charmander.png"));
    }
    
    public void squirtleSelect() {
        squirtleRadio.setDisable(true);
        bulbasaurRadio.setDisable(false);
        charmanderRadio.setDisable(false);
        charmanderRadio.setSelected(false);
        bulbasaurRadio.setSelected(false);
        pokemonPicture.setImage(new Image("/Pokemon/Squirtle.png"));
    }
    
    public void startClicked() {
        Game.starterPokemon = bulbasaurRadio.isSelected() ? 64 : charmanderRadio.isSelected() ? 24 : squirtleRadio.isSelected() ? 36 : 64;
        Game.playerName = nameField.getText();
        Game.playerGender = gender;
        GameObserver.startGame();
    }
    
    public void maleSelect() {
        maleRadio.setDisable(true);
        femaleRadio.setDisable(false);
        femaleRadio.setSelected(false);
        playerPicture.setImage(new Image("/male.png"));
        gender = 0;
    }
    
    public void femaleSelect() {
        femaleRadio.setDisable(true);
        maleRadio.setDisable(false);
        maleRadio.setSelected(false);
        playerPicture.setImage(new Image("/female.png"));
        gender = 1;
    }
}
