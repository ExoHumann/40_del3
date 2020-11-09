package Controller;

import Model.FieldList;
import Model.PlayerList;
import Model.Playerlist.Account;
import Model.Playerlist.Player;
import View.GameGUI;
//import java.lang.reflect.Array;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;

public class Chance {


    public Chance() {
    }

    int chance;
    private static final int deckSize = 20;
    public ArrayList<Integer> deck = new ArrayList<>(deckSize);

    public int drawCard() {
        Random r = new Random();
        chance = deck.get(r.nextInt(20));
        return chance;
    }

    public void printDeck(){
        System.out.println(deck);
    }

    public void Shuffle() {
        for (int i = 0; i < deckSize; i++) {
            deck.add(i);
        }
        Collections.shuffle(deck);
    }


    public void chance(PlayerList pl, FieldList fl, int playerTurn, Logic logic, GameGUI gameGUI) throws InterruptedException {
        Player player = pl.getPlayerList(playerTurn);
        Account account = pl.getAccount(playerTurn);
        int playerChoice;
        drawCard();
        Random r = new Random();
        chance = r.nextInt((12)+1);



        switch (chance) {
            case 0:
            case 1:
                gameGUI.showMessage("You move to start and get 2M");
                logic.movePlayer(pl,fl, fl.getSize()-logic.pos, playerTurn);
                gameGUI.moveToField(logic.prePos,playerTurn, 0);
                account.deposit(2);
                break;
            case 2:
                playerChoice = gameGUI.getUserButtons("Chose Between 1-5 fields to move up", 1,5);
                logic.movePlayer(pl,fl, playerChoice, playerTurn);
                gameGUI.fancyMoveGuiPlayer(logic.prePos,playerTurn, playerChoice);
                break;
            case 3:
                playerChoice = gameGUI.getUserButtons("Move to an orange field", 13,14);
                logic.movePlayer(pl,fl,fl.getSize() + playerChoice - logic.pos,playerTurn);
                gameGUI.moveToField(logic.prePos,playerTurn,playerChoice);
                gameGUI.buyField(pl,playerChoice,playerTurn);
                break;
            case 4:
               playerChoice = gameGUI.getUserButtons("Move one field or draw another card", 1,2);
                if (playerChoice == 1){
                    logic.movePlayer(pl,fl, playerChoice, playerTurn);
                    gameGUI.fancyMoveGuiPlayer(logic.prePos,playerTurn, playerChoice);
                } else if (playerChoice == 2) {
                   drawCard();
                }
                break;
            case 5:
                playerChoice = gameGUI.getUserButtons("Move to a light blue field", 16,17);
                logic.movePlayer(pl,fl,fl.getSize() + playerChoice - logic.pos,playerTurn);
                gameGUI.moveToField(logic.prePos,playerTurn,playerChoice);
                gameGUI.buyField(pl,playerChoice,playerTurn);
                break;
            case 6:
                playerChoice = gameGUI.getUserButtons("Move to an orange field", 13,14);
                logic.movePlayer(pl,fl,fl.getSize() + playerChoice - logic.pos,playerTurn);
                gameGUI.moveToField(logic.prePos,playerTurn,playerChoice);
                gameGUI.buyField(pl,playerChoice,playerTurn);
                break;
            case 7:
                playerChoice = gameGUI.getUserButtons("Move to a red field", 1,2);
                logic.movePlayer(pl,fl,fl.getSize() + playerChoice - logic.pos,playerTurn);
                gameGUI.moveToField(logic.prePos,playerTurn,playerChoice);
                gameGUI.buyField(pl,playerChoice,playerTurn);
                break;
            case 8:
                playerChoice = gameGUI.getUserButtons("Move to (1) an orange field or (2) a green field",1,2);
                if (playerChoice==1){
                    playerChoice = gameGUI.getUserButtons("Choose an orange field", 13,14);
                    logic.movePlayer(pl,fl,fl.getSize() + playerChoice - logic.pos,playerTurn);
                    gameGUI.moveToField(logic.prePos,playerTurn,playerChoice);
                    gameGUI.buyField(pl,playerChoice,playerTurn);}
                    else if(playerChoice==2){
                    playerChoice = gameGUI.getUserButtons("Choose a green field", 22,23);
                    logic.movePlayer(pl,fl,fl.getSize() + playerChoice - logic.pos,playerTurn);
                    gameGUI.moveToField(logic.prePos,playerTurn,playerChoice);
                    gameGUI.buyField(pl,playerChoice,playerTurn);}
                break;
            case 9:
                player.setGetOutOfJailCard();
                break;
            case 10:
                playerChoice = gameGUI.getUserButtons("Move to (1) a pink field or (2) a dark blue field",1,2);
                if (playerChoice==1){
                    playerChoice = gameGUI.getUserButtons("Choose a pink field", 19,20);
                    logic.movePlayer(pl,fl,fl.getSize() + playerChoice - logic.pos,playerTurn);
                    gameGUI.moveToField(logic.prePos,playerTurn,playerChoice);
                    gameGUI.buyField(pl,playerChoice,playerTurn);}
                else if(playerChoice==2){
                    playerChoice = gameGUI.getUserButtons("Choose a dark blue field", 10,11);
                    logic.movePlayer(pl,fl,fl.getSize() + playerChoice - logic.pos,playerTurn);
                    gameGUI.moveToField(logic.prePos,playerTurn,playerChoice);
                    gameGUI.buyField(pl,playerChoice,playerTurn);}
                break;
            case 11:
                playerChoice = gameGUI.getUserButtons("Move to (1) a light blue field or (2) a red field",1,2);
                if (playerChoice==1){
                    playerChoice = gameGUI.getUserButtons("Choose a light blue field", 16,17);
                    logic.movePlayer(pl,fl,fl.getSize() + playerChoice - logic.pos,playerTurn);
                    gameGUI.moveToField(logic.prePos,playerTurn,playerChoice);
                    gameGUI.buyField(pl,playerChoice,playerTurn);}
                else if(playerChoice==2){
                    playerChoice = gameGUI.getUserButtons("Choose a red field", 1,2);
                    logic.movePlayer(pl,fl,fl.getSize() + playerChoice - logic.pos,playerTurn);
                    gameGUI.moveToField(logic.prePos,playerTurn,playerChoice);
                    gameGUI.buyField(pl,playerChoice,playerTurn);}
                break;
            case 12:
                playerChoice = gameGUI.getUserButtons("Move to (1) a dark green field or (2) a yellow field",1,2);
                if (playerChoice==1){
                    playerChoice = gameGUI.getUserButtons("Choose a dark green field", 7,8);
                    logic.movePlayer(pl,fl,fl.getSize() + playerChoice - logic.pos,playerTurn);
                    gameGUI.moveToField(logic.prePos,playerTurn,playerChoice);
                    gameGUI.buyField(pl,playerChoice,playerTurn);}
                else if(playerChoice==2){
                    playerChoice = gameGUI.getUserButtons("Choose a yellow field", 4,5);
                    logic.movePlayer(pl,fl,fl.getSize() + playerChoice - logic.pos,playerTurn);
                    gameGUI.moveToField(logic.prePos,playerTurn,playerChoice);
                    gameGUI.buyField(pl,playerChoice,playerTurn);}
                break;
            case 13:
                gameGUI.showMessage("It's your birthday! Every player gives you 1M");
              for (int i = 0; i < pl.getPlayerAmount(); i++) {
                    pl.getAccount(pl.getPlayerAmount()).withdraw(1);
                    account.deposit(pl.getPlayerAmount());}
                    break;

            case 14:
                gameGUI.showMessage("You ate too much candy! pay 2M to the bank");
                account.withdraw(2);
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:


        }
    }
}
