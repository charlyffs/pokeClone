package com.charlyffs.main;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class StoreController {
    
    public Label balanceLabel;
    public Button potionBuyButton;
    public Button pokeballBuyButton;
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    
    public void buyPotion() {
        potionBuyButton.setDisable(true);
        if (Player.getBalance() >= 10) {
            Player.balance -= 10;
            balanceLabel.setText("" + Player.balance);
            alert.setHeaderText("You bought one potion");
            Player.getInventory().add(new Potion("Healing potion", 50));
        } else {
            alert.setHeaderText("You don't have enough money for that.");
        }
        alert.showAndWait();
        potionBuyButton.setDisable(false);
    }
    
    
    public void buyPokeball() {
        pokeballBuyButton.setDisable(true);
        if (Player.getBalance() >= 10) {
            Player.balance -= 10;
            balanceLabel.setText("" + Player.balance);
            alert.setHeaderText("You bought one pokeball");
            Player.getInventory().add(new Pokeball());
        } else {
            alert.setHeaderText("You don't have enough money for that.");
        }
        alert.showAndWait();
        pokeballBuyButton.setDisable(false);
    }
    
    public void exitButtonClicked() {
        GameObserver.hideStage();
    }
}
