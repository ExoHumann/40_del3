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
        int playerChoice = 0;
        logic.landedOnChance = false;
        logic.drawAnother = false;

        gameGUI.showMessage("Do you want to draw a chance card");
        Random r = new Random();
        chance = drawCard();

        chance = r.nextInt(3);

        switch (chance) {
            case 0: case 1:
                gameGUI.displayChance("You move to start and get 2M");
                logic.movePlayer(pl,fl, logic.moveAmount(0,fl), playerTurn);
                gameGUI.moveToField(logic.prePos,playerTurn, 0);
                account.deposit(2);
                break;
            case 2:
                gameGUI.displayChance("Chose Between 1-5 fields to move up");
                playerChoice = gameGUI.getUserButtons("Chose Between 1-5 fields to move up", 1,5);
                logic.movePlayer(pl,fl, playerChoice, playerTurn);
                gameGUI.fancyMoveGuiPlayer(logic.prePos,playerTurn, playerChoice);
                break;
            case 3:
                playerChoice = gameGUI.getUserButtons("Move to an orange field", 13,14);
                logic.movePlayer(pl,fl, logic.moveAmount(playerChoice,fl), playerTurn);
                gameGUI.moveToField(logic.prePos,playerTurn,playerChoice);
                break;
            case 4:
                if (playerChoice == 1){
                    player.move(1,fl);
                } else if (playerChoice == 2) {
                    logic.drawAnother = true;
                }
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                player.setGetOutOfJailCard();
            case 10:
            case 11:
            case 12:
            case 13:
                for (int i = 0; i < pl.getPlayerAmount(); i++) {
                    pl.getAccount(pl.getPlayerAmount()).withdraw(1);
                    account.deposit(pl.getPlayerAmount());
                }
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:


        }
    }
}
