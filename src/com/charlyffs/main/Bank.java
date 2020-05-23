package com.charlyffs.main;

import com.sun.source.tree.TryTree;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.util.ArrayList;

public class Bank {
    
    public Button belt1RemoveButton, bank1AddButton, belt2RemoveButton, bank2AddButton, beltPrevPageButton, beltNextPageButton, bankPrevPageButton, bankNextPageButton;
    public TextArea bank1InfoArea, bank2InfoArea, belt1InfoArea, belt2InfoArea;
    public Label belt1NameLabel, belt2NameLabel, bank1NameLabel, bank2NameLabel;
    public ImageView belt1ImageView, belt2ImageView, bank1ImageView, bank2ImageView;
    
    private int beltPage = 0, bankPage = 0;
    private final ArrayList<Pokemon> belt = Player.getPokemon();
    private final ArrayList<Pokemon> bank = Player.getBank();
    
    public void updatePreviews() {
    
        beltPrevPageButton.setDisable(beltPage == 0);
        bankPrevPageButton.setDisable(bankPage == 0);
        
        Pokemon
                belt1Pokemon = null,
                belt2Pokemon = null,
                bank1Pokemon = null,
                bank2Pokemon = null;
        try {
            belt1Pokemon = belt.get(beltPage);
            belt2Pokemon = belt.get(beltPage + 1);
        } catch (Exception ignored) {
        }
    
        try {
            bank1Pokemon = bank.get(bankPage);
            bank2Pokemon = bank.get(bankPage + 1);
        } catch (Exception ignored) {
        }
    
        setPanels(belt1Pokemon, belt1NameLabel, belt1InfoArea, belt1ImageView, beltNextPageButton, belt1RemoveButton);
        setPanels(belt2Pokemon, belt2NameLabel, belt2InfoArea, belt2ImageView, beltNextPageButton, belt2RemoveButton);
    
        setPanels(bank1Pokemon, bank1NameLabel, bank1InfoArea, bank1ImageView, bankNextPageButton, bank1AddButton);
        setPanels(bank2Pokemon, bank2NameLabel, bank2InfoArea, bank2ImageView, bankNextPageButton, bank2AddButton);
        
        bank1AddButton.setDisable(belt.size() == 6);
        bank2AddButton.setDisable(belt.size() == 6);
        
    }
    
    private void setPanels(Pokemon Pokemon, Label NameLabel, TextArea InfoArea, ImageView ImageView, Button NextPageButton, Button addRemoveButton) {
        try {
            NameLabel.setText(Pokemon.getName());
            InfoArea.setText(infoText(Pokemon));
            ImageView.setImage(new Image(Pokemon.getURL()));
            NextPageButton.setDisable(false);
            addRemoveButton.setDisable(false);
        } catch (Exception e) {
            NameLabel.setDisable(true);
            InfoArea.setDisable(true);
            ImageView.setImage(null);
            NextPageButton.setDisable(true);
            addRemoveButton.setDisable(true);
        }
        try {
            belt.get(beltPage + 2);
        } catch (Exception e) {
            beltNextPageButton.setDisable(true);
        }
        try {
            bank.get(bankPage + 2);
        } catch (Exception e) {
            bankNextPageButton.setDisable(true);
        }
    }
    
    private String infoText(Pokemon pokemon) {
        return "";
    }
    
    public void belt1RemoveButtonClicked() {
    
        bank.add(0, belt.get(beltPage));
        belt.remove(beltPage);
        updatePreviews();
    
    }
    
    public void belt2RemoveButtonClicked() {
    
        bank.add(0, belt.get(beltPage + 1));
        belt.remove(beltPage + 1);
        updatePreviews();
    
    }
    
    public void bank1AddButtonClicked() {
    
        belt.add(0, bank.get(bankPage));
        bank.remove(bankPage);
        updatePreviews();
    
    }
    
    public void bank2AddButtonClicked() {
    
        belt.add(0, bank.get(bankPage + 1));
        bank.remove(bankPage + 1);
        updatePreviews();
    
    }
    
    public void beltNextPageButtonClicked() {
        beltPage += 2;
        updatePreviews();
    }
    
    public void beltPrevPageButtonClicked() {
        beltPage -= 2;
        updatePreviews();
    }
    
    public void bankNextPageButtonClicked() {
        bankPage += 2;
        updatePreviews();
    }
    
    public void bankPrevPageButtonClicked() {
        bankPage -= 2;
        updatePreviews();
    }
    
    public void exitButtonClicked() {
        GameObserver.hideStage();
    }
}
