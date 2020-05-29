package com.charlyffs.main;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.ArrayList;
import java.util.Random;

public class Fight {
    
    public Pane pokemonHealthBar, enemyHealthBar;
    public ImageView Pokemon1Image, Pokemon2Image, Pokemon3Image;
    public ImageView playerImageView, enemyImageView,item1Image, item2Image, item3Image;
    public TextArea actionButtonsContainer, invBackground, pokemonBackground;
    public Label pokemonName, pokemonLevel, enemyName, enemyLevel;
    public Label Pokemon1DataLabel, Pokemon2DataLabel, Pokemon3DataLabel;
    public Button invItem1Btn, invItem2Btn, invItem3Btn, invPrevPageBtn, invNextPageBtn;
    public Button pokemon1Button,pokemon2Button ,pokemon3Button ,pokemonPrevPageBtn, pokemonNextPageBtn;
    public Button action1Button, action2Button, action3Button, action4Button;
    
    private boolean fightBtnState, invBtnState, pokemonBtnState;
    private ArrayList<Pokemon> pokemonInventory, enemyPokemonList;
    private ArrayList<Item> inventory;
    private Pokemon playerPokemon, enemyPokemon;
    private int pokemonIndex, z;
    private final Random RNG = new Random();
    public static boolean isGym = false;
    
    void startFight(int type, boolean gym, int z) {
        this.z = z;
        isGym = gym;
        
        pokemonInventory = Player.getPokemon();
        enemyPokemonList = new ArrayList<>();
        
        int x = 0;
        int sum = 0;
        for (Pokemon pokemon : pokemonInventory) {
            sum += pokemon.getLevel();
            x++;
        }
        
        x = sum / x;
        x--;
    
        x = Math.min(x, 60);
        
        //If gym, get 6 random pokemon of specified type, else, get 1 pokemon
        for (int i = 0; i < (isGym ? 6 : 1); i++) {
            //todo make type skip over pokemon of other type
            //(if type is 20, this includes pokemon 1-10, which could be of another type).
            int index = RNG.nextInt(type);
            enemyPokemonList.add(DataBase.getPokeDex().get(index).clone());
        }
        
        for (Pokemon pokemon : enemyPokemonList) {
            int index = enemyPokemonList.indexOf(pokemon);
            for (int i = 0; i < (isGym ? z : x); i++) {
                enemyPokemonList.set(index, Pokemon.levelup(pokemon));
                pokemon = enemyPokemonList.get(index);
            }
        }
        
        enemyPokemon = enemyPokemonList.get(0);
    
        playerPokemon = null;
        getLivingPokemon();
        
        inventory = Player.getInventory();
    
        //Fixes the UI because all menus start visible
        fightBtnState = true;
        invBtnState = false;
        pokemonBtnState = false;
        fightButtonClick();
        invBtnState = true;
        bagButtonClicked();
        pokemonBtnState = true;
        pokemonButtonClick();
        
        setEnemyVisuals();
        
        setPokemonVisuals();
        updateBars();
        printData();
    }
    
    private void setEnemyVisuals() {
        Platform.runLater(() -> {
            enemyImageView.setImage(new Image(enemyPokemon.getURL()));
            enemyLevel.setText("Level: " + enemyPokemon.getLevel());
            enemyName.setText(enemyPokemon.getName());
        });
    }
    
    private void setPokemonVisuals() {
        Platform.runLater(() -> {
            playerImageView.setImage(new Image(playerPokemon.getURL()));
            pokemonLevel.setText("Level: " + playerPokemon.getLevel());
            pokemonName.setText(playerPokemon.getName());
            
            setButtonData(action1Button, 0);
            setButtonData(action2Button, 1);
            setButtonData(action3Button, 2);
            setButtonData(action4Button, 3);
        });
    }
    
    private void setButtonData(Button button, int index) {
        try {
            button.setText(playerPokemon.getAttacks().get(index).getName());
        } catch (Exception e) {
            button.setDisable(true);
            button.setText("");
        }
    }
    
    public void quitFight() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
         if (enemyPokemon.getCurrentHP() < 1) {
             pokemonInventory.add(pokemonIndex, playerPokemon);
             Audio.playFile("/Audio/Victory.mp3");
             alert.setHeaderText("Victory");
             Player.setBalance(Player.getBalance() + 15);
             
             for (Pokemon pokemon : pokemonInventory) {
                 if (pokemon.isParticipated()) {
                     pokemonInventory.set(pokemonInventory.indexOf(pokemon), Pokemon.endOfBattle(pokemon));
                 }
             }
             
             if (isGym) {
                 GameObserver.gymBeaten();
                 Game.medals += 1;
                 switch (z / 10) {
                     case 1:
                         Game.medal1.setRendering(true);
                         break;
                     case 2:
                         Game.medal2.setRendering(true);
                         break;
                     case 3:
                         Game.medal3.setRendering(true);
                         break;
                     case 4:
                         System.out.println("Game over");
                 }
                 if (Game.medals == 3) {
                     alert.setHeaderText("Congratulations " + Game.player.getName() + "! You won the game!");
                     alert.setTitle("GOODBYE");
                     alert.showAndWait();
//                     System.exit(0);
                 }
             }
        } else {
            alert.setHeaderText("Defeat");
        }
        alert.showAndWait();
        enemyPokemon.reset();
        GameObserver.hideStage();
    }
    
    private void printData() {
        System.out.println("Player HP: " + playerPokemon.getCurrentHP());
        System.out.println("Enemy HP: " + enemyPokemon.getCurrentHP());
    }
    
    public void doAction1() {
        Audio.playAttack();
        playerPokemon.getAttacks().get(0).use(playerPokemon, enemyPokemon);
        changeTurn();
    }
    
    public void doAction2() {
        Audio.playAttack();
        playerPokemon.getAttacks().get(1).use(playerPokemon, enemyPokemon);
        changeTurn();
    }
    
    public void doAction3() {
        Audio.playAttack();
        playerPokemon.getAttacks().get(2).use(playerPokemon, enemyPokemon);
        changeTurn();
    }
    
    public void doAction4() {
        Audio.playAttack();
        playerPokemon.getAttacks().get(3).use(playerPokemon, enemyPokemon);
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
        invPrevPageBtn.setDisable(invPage == 0);
        invNextPageBtn.setDisable(false);
        setButtonStuff(invItem1Btn, item1Image, invPage);
        setButtonStuff(invItem2Btn, item2Image, invPage + 1);
        setButtonStuff(invItem3Btn, item3Image, invPage + 2);
    }
    
    private void setButtonStuff(Button button, ImageView imageView, int index) {
        try {
            button.setText(inventory.get(index).getName());
            imageView.setImage(new Image("/" + inventory.get(index).getName() + ".png"));
            button.setDisable(false);
            button.setVisible(true);
            imageView.setVisible(true);
        } catch (Exception e) {
            invNextPageBtn.setDisable(true);
            imageView.setVisible(false);
            button.setVisible(false);
        }
    }
    
    public void runClicked() {
        pokemonInventory.add(pokemonIndex, playerPokemon);
        quitFight();
    }
    
    private void changeTurn() {
        if (enemyPokemon.getCurrentHP() < 1) {
            enemyDead();
            setEnemyVisuals();
            updateBars();
        } else {
            Random RNG = new Random();
            enemyPokemon.getAttacks().get(RNG.nextInt(enemyPokemon.getAttacks().size())).use(enemyPokemon, playerPokemon);
            updateBars();
            if (playerPokemon.getCurrentHP() < 1){
                getLivingPokemon();
            }
        }
        printData();
    }
    
    private void getLivingPokemon() {
        if (playerPokemon != null) {
            pokemonInventory.add(pokemonIndex, playerPokemon);
        }
        for (Pokemon pokemon : pokemonInventory) {
            if (pokemon.getCurrentHP() > 0) {
                pokemonIndex = pokemonInventory.indexOf(pokemon);
                playerPokemon = pokemon;
                setPokemonVisuals();
                updateBars();
                break;
            }
        }
        if (playerPokemon.getCurrentHP() <= 0) {
            quitFight();
        } else {
            pokemonInventory.remove(pokemonIndex);
            playerPokemon.setParticipated(true);
        }
    }
    
    private void updateBars() {
        Platform.runLater(() -> {
            pokemonHealthBar.setMaxWidth((double) playerPokemon.getCurrentHP() / playerPokemon.getHp() * 156.0);
            enemyHealthBar.setMaxWidth((double) enemyPokemon.getCurrentHP() / enemyPokemon.getHp() * 156.0);
        });
    }
    
    public void useInvItem1() {
        useInvItem(invPage);
    }
    
    public void useInvItem2() {
        useInvItem(invPage + 1);
    }
    
    public void useInvItem3() {
        useInvItem(invPage + 2);
    }
    
    private void useInvItem(int index) {
        if (inventory.get(index).use(playerPokemon, enemyPokemon)) {
            inventory.remove(index);
            updateInventoryButtons();
            updateBars();
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
        changePokemon(pokemonPage);
    }
    
    public void pokemon2ButtonClick() {
        changePokemon(pokemonPage + 1);
    }
    
    public void pokemon3ButtonClick() {
        changePokemon(pokemonPage + 2);
    }
    
    private void changePokemon(int index) {
        Pokemon newPokemon = pokemonInventory.get(index);
        pokemonInventory.add(pokemonIndex, playerPokemon);
        pokemonIndex = pokemonInventory.indexOf(newPokemon);
        pokemonInventory.remove(pokemonIndex);
        playerPokemon = newPokemon;
        setPokemonVisuals();
        changeTurn();
        updatePokemonInv();
        playerPokemon.setParticipated(true);
    }
    
    private void enemyDead() {
        enemyPokemonList.remove(0);
        try {
            enemyPokemon = enemyPokemonList.get(0);
        } catch (Exception e) {
            quitFight();
        }
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
        pokemonPrevPageBtn.setDisable(pokemonPage == 0);
        setPokemonInvStuff(pokemon1Button, Pokemon1Image, Pokemon1DataLabel, pokemonPage);
        setPokemonInvStuff(pokemon2Button, Pokemon2Image, Pokemon2DataLabel, pokemonPage + 1);
        setPokemonInvStuff(pokemon3Button, Pokemon3Image, Pokemon3DataLabel, pokemonPage + 2);
    }
    
    private void setPokemonInvStuff(Button button, ImageView imageView, Label label, int index) {
        Pokemon holder;
        try {
            holder = pokemonInventory.get(index);
            label.setText(holder.getName() + ". Level: " + holder.getLevel() + ". HP: " + holder.getCurrentHP() + ".");
            imageView.setImage(new Image(holder.getURL()));
            imageView.setVisible(true);
            button.setVisible(true);
            button.setDisable(holder.getCurrentHP() < 1);
            label.setVisible(true);
            pokemonNextPageBtn.setDisable(false);
        } catch (Exception e) {
            button.setVisible(false);
            label.setVisible(false);
            imageView.setVisible(false);
            pokemonNextPageBtn.setDisable(true);
        }
    }
    
}
