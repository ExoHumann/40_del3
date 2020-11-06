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


    public void chance(PlayerList pl, FieldList fl, int playerTurn, int playerChoice){
        Player player = pl.getPlayerList(playerTurn);
        Account account = pl.getAccount(playerTurn);

        drawCard();

        switch (chance) {
            case 0:
            case 1:
                player.setCurrentPosition(0);
                account.deposit(2);
            case 2:
                player.move(playerChoice, fl);
            case 3:
                if (playerChoice == 12){
                    player.setCurrentPosition(13);
                } else if (playerChoice == 13) {
                    player.setCurrentPosition(14);
                }
            case 4:
                if (playerChoice == 1){
                    player.move(1,fl);
                } else if (playerChoice == 2) {
                    drawCard();
                }
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                player.setJailCard();
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
