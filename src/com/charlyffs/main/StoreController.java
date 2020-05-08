package com.charlyffs.main;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class StoreController {
    
    public Label balanceLabel;
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    
    public void buyPotion() {
        if (Player.getBalance() > 10) {
            Player.balance -= 10;
            balanceLabel.setText("" + Player.balance);
            alert.setHeaderText("You bought one potion");
            Player.getInventory().add(new Potion("Healing potion", 50));
        } else {
            alert.setHeaderText("You don't have enough money for that.");
        }
        alert.showAndWait();
    }
    
    
    public void buyPokeball() {
        if (Player.getBalance() > 10) {
            Player.balance -= 10;
            balanceLabel.setText("" + Player.balance);
            alert.setHeaderText("You bought one pokeball");
            Player.getInventory().add(new Pokeball("Pokeball"));
        } else {
            alert.setHeaderText("You don't have enough money for that.");
        }
        alert.showAndWait();
    }
    
}
