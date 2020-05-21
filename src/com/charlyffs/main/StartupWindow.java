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
    private int gender;
    
    public void bulbasaurSelect() {
        charmanderRadio.setSelected(false);
        squirtleRadio.setSelected(false);
        pokemonPicture.setImage(new Image("/Pokemon/Bulbasaur/Bulbasaur.png"));
    }
    
    public void charmanderSelect() {
        bulbasaurRadio.setSelected(false);
        squirtleRadio.setSelected(false);
        pokemonPicture.setImage(new Image("/Pokemon/Charmander/Charmander.png"));
    }
    
    public void squirtleSelect() {
        charmanderRadio.setSelected(false);
        bulbasaurRadio.setSelected(false);
        pokemonPicture.setImage(new Image("/Pokemon/Squirtle/Squirtle.png"));
    }
    
    public void startClicked() {
        Game.starterPokemon = bulbasaurRadio.isSelected() ? 0 : charmanderRadio.isSelected() ? 1 : squirtleRadio.isSelected() ? 2 : 0;
        Game.playerName = nameField.getText();
        Game.playerGender = gender;
        GameObserver.startGame();
    }
    
    public void maleSelect() {
        femaleRadio.setSelected(false);
        playerPicture.setImage(new Image("/male.png"));
        gender = 0;
    }
    
    public void femaleSelect() {
        maleRadio.setSelected(false);
        playerPicture.setImage(new Image("/female.png"));
        gender = 1;
    }
}
