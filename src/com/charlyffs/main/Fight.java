package com.charlyffs.main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.Random;

public class Fight {
    
    public TextArea actionButtonsContainer, invBackground, pokemonBackground;
    public Pane pokemonHealthBar, enemyHealthBar;
    public Label pokemonName, pokemonLevel, enemyName, enemyLevel;
    
    private boolean fightBtnState, invBtnState, pokemonBtnState;
    public Button invItem1Btn, invItem2Btn, invItem3Btn, invPrevPageBtn, invNextPageBtn;
    public Button pokemon1Button,pokemon2Button ,pokemon3Button ,pokemonPrevPageBtn, pokemonNextPageBtn;
    public Label Pokemon1DataLabel, Pokemon2DataLabel, Pokemon3DataLabel;
    public ImageView Pokemon1Image, Pokemon2Image, Pokemon3Image;
    public Button action1Button, action2Button, action3Button, action4Button;
    
    public ImageView playerImageView, enemyImageView,item1Image, item2Image, item3Image;
    private ArrayList<Pokemon> pokemonInventory;
    private Pokemon playerPokemon, enemyPokemon;
    private ArrayList<Item> inventory;
    private int pokemonIndex;
    
    void startFight(Pokemon enemy) {
        System.out.println("Starting fight...");
        //Set all data for current fight.
        Platform.runLater(() -> {
            this.pokemonInventory = Player.getPokemon();
            inventory = Player.getInventory();
            pokemonIndex = 0;
            this.playerPokemon = pokemonInventory.get(0);
            pokemonInventory.remove(0);
            
            this.enemyPokemon = enemy;
            enemyImageView.setImage(new Image(enemy.getURL()));
            enemyLevel.setText("Level: " + enemyPokemon.getLevel());
            enemyName.setText(enemyPokemon.getName());
        
            setPokemonVisuals();
            updateBars();
            printData();
        
            fightBtnState = true;
            invBtnState = false;
            pokemonBtnState = false;
            fightButtonClick();
            invBtnState = true;
            bagButtonClicked();
            pokemonBtnState = true;
            pokemonButtonClick();
        });
    }
    
    private void setPokemonVisuals() {
        playerImageView.setImage(new Image(playerPokemon.getURL()));
        pokemonLevel.setText("Level: " + playerPokemon.getLevel());
        pokemonName.setText(playerPokemon.getName());
    
        int i = 0;
        try {
            action1Button.setText(playerPokemon.getMoves().get(i).name);
            i++;
            action2Button.setText(playerPokemon.getMoves().get(i).name);
            i++;
            action3Button.setText(playerPokemon.getMoves().get(i).name);
            i++;
            action4Button.setText(playerPokemon.getMoves().get(i).name);
        } catch (Exception e) {
            switch (i) {
                case 0:
                    action1Button.setDisable(true);
                    action1Button.setText("");
                case 1:
                    action2Button.setDisable(true);
                    action2Button.setText("");
                case 2:
                    action3Button.setDisable(true);
                    action3Button.setText("");
                case 3:
                    action4Button.setDisable(true);
                    action4Button.setText("");
            }
        }
    }
    
    public void quitFight() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
         if (enemyPokemon.getCurrentHP() < 1) {
            alert.setHeaderText("WIN");
            Player.setBalance(Player.getBalance() + 15);
            playerPokemon.endOfBattle();
        } else {
            alert.setHeaderText("LOSE");
        }
        alert.showAndWait();
        pokemonInventory.add(pokemonIndex, playerPokemon);
        enemyPokemon.reset();
        GameObserver.hideStage();
        GameObserver.backToGame();
    }
    
    private void printData() {
        System.out.println("Player HP: " + playerPokemon.getCurrentHP());
        System.out.println("Enemy HP: " + enemyPokemon.getCurrentHP());
    }
    
    public void doAction1() {
        playerPokemon.getMoves().get(0).use(playerPokemon, enemyPokemon);
        changeTurn();
    }
    
    public void doAction2() {
        playerPokemon.getMoves().get(1).use(playerPokemon, enemyPokemon);
        changeTurn();
    }
    
    public void doAction3() {
        playerPokemon.getMoves().get(2).use(playerPokemon, enemyPokemon);
        changeTurn();
    }
    
    public void doAction4() {
        playerPokemon.getMoves().get(3).use(playerPokemon, enemyPokemon);
        changeTurn();
    }
    
    public void fightButtonClick() {
        if (pokemonBtnState) {
            pokemonButtonClick();
        }
        if (invBtnState) {
            bagButtonClicked();
        }
        fightBtnState = !fightBtnState;
        
        action1Button.setVisible(fightBtnState);
        action2Button.setVisible(fightBtnState);
        action3Button.setVisible(fightBtnState);
        action4Button.setVisible(fightBtnState);
        actionButtonsContainer.setVisible(fightBtnState);
    }
    
    int invPage, pokemonPage;
    
    public void bagButtonClicked() {
        if (pokemonBtnState) {
            pokemonButtonClick();
        }
        if (fightBtnState) {
            fightButtonClick();
        }
        
        invBtnState = !invBtnState;
    
        invPage = 0;
        
        invItem1Btn.setVisible(invBtnState);
        invItem2Btn.setVisible(invBtnState);
        invItem3Btn.setVisible(invBtnState);
        item1Image.setVisible(invBtnState);
        item2Image.setVisible(invBtnState);
        item3Image.setVisible(invBtnState);
        invNextPageBtn.setVisible(invBtnState);
        invPrevPageBtn.setVisible(invBtnState);
        invBackground.setVisible(invBtnState);
    
        if (invBtnState) {
            updateInventoryButtons();
        }
    }
    
    public void pokemonButtonClick() {
        if (fightBtnState) {
            fightButtonClick();
        }
        if (invBtnState) {
            bagButtonClicked();
        }
        
        pokemonBtnState = !pokemonBtnState;
        
        pokemonBackground.setVisible(pokemonBtnState);
        Pokemon1Image.setVisible(pokemonBtnState);
        Pokemon2Image.setVisible(pokemonBtnState);
        Pokemon3Image.setVisible(pokemonBtnState);
        pokemon1Button.setVisible(pokemonBtnState);
        pokemon2Button.setVisible(pokemonBtnState);
        pokemon3Button.setVisible(pokemonBtnState);
        pokemonNextPageBtn.setVisible(pokemonBtnState);
        pokemonPrevPageBtn.setVisible(pokemonBtnState);
        Pokemon1DataLabel.setVisible(pokemonBtnState);
        Pokemon2DataLabel.setVisible(pokemonBtnState);
        Pokemon3DataLabel.setVisible(pokemonBtnState);
    
        pokemonPage = 0;
        if (pokemonBtnState) {
            updatePokemonInv();
        }
    }
    
    private void updateInventoryButtons() {
        int i = 0;
        invPrevPageBtn.setDisable(invPage == 0);
        try {
                invItem1Btn.setText(inventory.get(invPage).getName());
                invItem1Btn.setDisable(false);
                invItem1Btn.setVisible(true);
                i++;
                invItem2Btn.setText(inventory.get(invPage + 1).getName());
                invItem2Btn.setDisable(false);
                invItem2Btn.setVisible(true);
                i++;
                invItem3Btn.setText(inventory.get(invPage + 2).getName());
                invItem3Btn.setDisable(false);
                invItem3Btn.setVisible(true);
                invNextPageBtn.setDisable(false);
        } catch (Exception e) {
            invNextPageBtn.setDisable(true);
            switch (i) {
                case 0:
                    invItem1Btn.setVisible(false);
                case 1:
                    invItem2Btn.setVisible(false);
                case 2:
                    invItem3Btn.setVisible(false);
            }
        }
    }
    
    public void runClicked() {
        quitFight();
    }
    
    private void changeTurn() {
        if (enemyPokemon.getCurrentHP() < 1) {
            quitFight();
        }
        Random RNG = new Random();
        enemyPokemon.getMoves().get(RNG.nextInt(enemyPokemon.getMoves().size())).use(enemyPokemon, playerPokemon);
        updateBars();
        if (playerPokemon.getCurrentHP() < 1) {
            quitFight();
        }
        printData();
    }
    
    private void updateBars() {
        pokemonHealthBar.setPrefWidth((double) playerPokemon.getCurrentHP() / playerPokemon.getHp() * 156.0);
        enemyHealthBar.setPrefWidth((double) enemyPokemon.getCurrentHP() / enemyPokemon.getHp() * 156.0);
    }
    
    public void useInvItem1() {
        if (inventory.get(invPage).use(playerPokemon, enemyPokemon)) {
            inventory.remove(invPage);
            updateInventoryButtons();
            changeTurn();
        }
    }
    
    public void useInvItem2() {
        if (inventory.get(invPage + 1).use(playerPokemon, enemyPokemon)) {
            inventory.remove(invPage + 1);
            updateInventoryButtons();
            changeTurn();
        }
    }
    
    public void useInvItem3() {
        if (inventory.get(invPage + 2).use(playerPokemon, enemyPokemon)) {
            inventory.remove(invPage + 2);
            updateInventoryButtons();
            changeTurn();
        }
    }
    
    public void invPrevPage() {
        invPage -= 3;
        updateInventoryButtons();
    }
    
    public void invNextPage() {
        invPage += 3;
        updateInventoryButtons();
    }
    
    public void pokemon1ButtonClick() {
        Pokemon newPokemon = pokemonInventory.get(pokemonPage);
        pokemonInventory.add(pokemonIndex, playerPokemon);
        pokemonIndex = pokemonInventory.indexOf(newPokemon);
        pokemonInventory.remove(pokemonIndex);
        playerPokemon = newPokemon;
        setPokemonVisuals();
        changeTurn();
        updatePokemonInv();
    }
    
    public void pokemon2ButtonClick() {
        Pokemon newPokemon = pokemonInventory.get(pokemonPage + 1);
        pokemonInventory.add(pokemonIndex, playerPokemon);
        pokemonIndex = pokemonInventory.indexOf(newPokemon);
        pokemonInventory.remove(pokemonIndex);
        playerPokemon = newPokemon;
        setPokemonVisuals();
        changeTurn();
        updatePokemonInv();
    }
    
    public void pokemon3ButtonClick() {
        Pokemon newPokemon = pokemonInventory.get(pokemonPage + 2);
        pokemonInventory.add(pokemonIndex, playerPokemon);
        pokemonIndex = pokemonInventory.indexOf(newPokemon);
        pokemonInventory.remove(pokemonIndex);
        playerPokemon = newPokemon;
        setPokemonVisuals();
        changeTurn();
        updatePokemonInv();
    }
    
    public void pokemonPrevPageClick() {
        pokemonPage -= 3;
        updatePokemonInv();
    }
    
    public void pokemonNextPageClick() {
        pokemonPage += 3;
        updatePokemonInv();
    }
    
    private void updatePokemonInv() {
        int i = 0;
        Pokemon holder;
        pokemonPrevPageBtn.setDisable(pokemonPage == 0);
        try {
            holder = pokemonInventory.get(pokemonPage);
            Pokemon1DataLabel.setText(holder.getName() + ". Level: " + holder.getLevel() + ".");
            Pokemon1Image.setImage(new Image(holder.getURL()));
            pokemon1Button.setDisable(false);
            pokemon1Button.setVisible(true);
            Pokemon1DataLabel.setVisible(true);
            Pokemon1Image.setVisible(true);
            i++;
            holder = pokemonInventory.get(pokemonPage + 1);
            Pokemon2DataLabel.setText(holder.getName() + ". Level: " + holder.getLevel() + ".");
            Pokemon2Image.setImage(new Image(holder.getURL()));
            pokemon2Button.setDisable(false);
            pokemon2Button.setVisible(true);
            Pokemon2DataLabel.setVisible(true);
            Pokemon2Image.setVisible(true);
            i++;
            holder = pokemonInventory.get(pokemonPage + 2);
            Pokemon3DataLabel.setText(holder.getName() + ". Level: " + holder.getLevel() + ".");
            Pokemon3Image.setImage(new Image(holder.getURL()));
            pokemon3Button.setDisable(false);
            pokemon3Button.setVisible(true);
            pokemonNextPageBtn.setDisable(false);
            Pokemon3DataLabel.setVisible(true);
            Pokemon3Image.setVisible(true);
        } catch (Exception e) {
            pokemonNextPageBtn.setDisable(true);
            switch (i) {
                case 0:
                    pokemon1Button.setVisible(false);
                    Pokemon1DataLabel.setVisible(false);
                    Pokemon1Image.setVisible(false);
                case 1:
                    pokemon2Button.setVisible(false);
                    Pokemon2DataLabel.setVisible(false);
                    Pokemon2Image.setVisible(false);
                case 2:
                    pokemon3Button.setVisible(false);
                    Pokemon3DataLabel.setVisible(false);
                    Pokemon3Image.setVisible(false);
            }
        }
    }
}
