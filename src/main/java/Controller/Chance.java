package Controller;

import Model.FieldList;
import Model.PlayerList;
import Model.Playerlist.Account;
import Model.Playerlist.Player;

import java.util.Random;

public class Chance {


    public Chance() {
    }


    int chance;

    public void drawCard(){
        int amountOfCards = 20;
        Random r = new Random(amountOfCards);
        chance = r.nextInt();
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
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:


        }
    }




}
