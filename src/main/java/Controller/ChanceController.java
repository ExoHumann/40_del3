package Controller;

import Model.FieldList;
import Model.Fields.Field;
import Model.Fields.Ownable;
import Model.PlayerList;
import Model.Playerlist.Player;
import View.GameGUI;
import java.awt.*;
import java.util.Collections;
import java.util.ArrayList;

public class ChanceController {

    public ChanceController() {
    }

    int chanceCard = 0;
    int chance;
    private static final int deckSize = 18;
    public ArrayList<Integer> deck = new ArrayList<>(deckSize);

    public int drawCard() {
        chance = deck.get(chanceCard);
        chanceCard++;
        if (chanceCard >= deckSize) {
            chanceCard = 0;
        }
        return chance;
    }

    public void printDeck() {
        System.out.println(deck);
        System.out.println("Array index" + chanceCard + " ChanceCard: " + deck.get(chanceCard));
    }

    public void shuffle() {
        for (int i = 0; i < deckSize; i++) {
            deck.add(i);
        }
        Collections.shuffle(deck);
    }


    public String colorToString(Color color) {
        String stringColor = " ";

        if (Color.red.equals(color)) stringColor = "red";
        if (Color.yellow.equals(color)) stringColor = "yellow";
        if (new Color(0, 100, 0).equals(color)) stringColor = "dark green";
        if (Color.blue.equals(color)) stringColor = "blue";
        if (Color.orange.equals(color)) stringColor = "orange";
        if (Color.cyan.equals(color)) stringColor = "light blue";
        if (Color.pink.equals(color)) stringColor = "pink";
        if (Color.green.equals(color)) stringColor = "green";

        stringColor = "Move to an " + stringColor + " field";
        return stringColor;
    }

    private void choseFields(Logic logic, GameGUI gameGUI, FieldList fl, Player p, Color color, boolean free) {
        int[] fields = getPossibleFields(color, fl);
        String colorToString = colorToString(color);
        int playerChoice;
        gameGUI.displayChance(colorToString);
        playerChoice = gameGUI.getUserButtons(colorToString, fields[0], fields[1]);
        p.setCurrentPosition(playerChoice);
        gameGUI.moveToField(p);
        if (free){
            Ownable field = (Ownable) fl.getField(p.getCurrentPosition());
            if (field.getOwner() == null)
                p.getAccount().deposit(field.getPrice());
        }
        logic.landedOn(p, fl);
    }
    private void choseMoveAmount(Player p, FieldList fl, int moveAmount, GameGUI gameGUI){
        int playerChoice;
        gameGUI.displayChance("Move up to " + moveAmount + " fields");
        playerChoice = gameGUI.getUserButtons("Move up to " + moveAmount + " fields",1,moveAmount);
        p.move(playerChoice, fl);
        gameGUI.fancyMoveGuiPlayer(p,playerChoice);
    }

    private void receivesMoneyFromPlayers(Player p, PlayerList pl, int amount, GameGUI gameGUI){
        gameGUI.displayChance("You will now receive " + amount + " from all players");
        gameGUI.showMessage("You will now receive "+ amount + " from all players");
        for (int i = 0; i < pl.getPlayerAmount(); i++) {
        pl.getAccount(i).pay(amount, p.getAccount());
        }
        p.getAccount().withdraw(amount);
    }

    private void moveToAField(Player p,Logic logic, GameGUI gameGUI, int moveToPosition, FieldList fl, boolean free){
        gameGUI.displayChance("You will now move to field " + moveToPosition);
        gameGUI.showMessage("You will now move to field "+ moveToPosition);
        p.setCurrentPosition(moveToPosition);
        gameGUI.moveToField(p);
        if (free){
            Ownable field = (Ownable) fl.getField(p.getCurrentPosition());
            if (field.getOwner() == null)
                p.getAccount().deposit(field.getPrice());
        } else
        logic.landedOn(p,fl);
    }

    private void giveThisCardTo(Player p, PlayerList pl, GameGUI gameGUI){
        Player nextPlayer = pl.getPlayerList((p.getNum()+1)%pl.getPlayerAmount());
        gameGUI.displayChance(nextPlayer.getName() + " Wil buy the next possible field on his next turn");
        gameGUI.showMessage(nextPlayer.getName() + " Wil buy the next possible field on his next turn");
        nextPlayer.buyNextPossibleField = true;
    }

    public int[] getPossibleFields(Color color, FieldList fl) {
        int colorAmount = 0;

        for (int i = 0; i < fl.getSize(); i++) {
            Field field = fl.getField(i);

            if (field instanceof Ownable) {
                if (field.getColor() == color)
                    colorAmount++;
            }
        }

        int[] fields = new int[colorAmount];
        int index = 0;

        for (int i = 0; i < fl.getSize(); i++) {
            Field field = fl.getField(i);

            if (field instanceof Ownable) {
                if (field.getColor() == color) {
                    fields[index] = i;
                    index++;
                }
            }
        }
        return fields;
    }

    public void chance(Player p,PlayerList pl, FieldList fl, Logic logic, GameGUI gameGUI) {

        printDeck();
        chance = drawCard();
        int playerChoice;

        switch (chance) {
            case 1: case 6: case 13: case 12:
                giveThisCardTo(p, pl, gameGUI);
                break;

            case 2:
                moveToAField(p,logic, gameGUI,0,fl,false );
                break;

            case 3:
                choseMoveAmount(p,fl,5, gameGUI);
                logic.landedOn(p,fl);
                break;

            case 4:
                choseFields(logic, gameGUI, fl, p, Color.orange, false);
                break;

            case 5:
                playerChoice = gameGUI.getUserButtons("(1) Move 1 field (2) Take another chance Card",1,2);
                if (playerChoice == 1) {
                    choseMoveAmount(p,fl,1,gameGUI);
                    logic.landedOn(p,fl);
            } else
                gameGUI.showMessage("You will now draw another chance card");
                logic.drawAnother = true;
                break;

            case 7:
                p.getAccount().withdraw(2);
                break;

            case 8:
                playerChoice = gameGUI.getUserButtons("Chose which color you want to move to (1) Orange field (2) Green field", 1,2);
                if (playerChoice == 1)
                    choseFields(logic, gameGUI, fl, p, Color.orange, false);
                else
                    choseFields(logic, gameGUI, fl, p, Color.green, false);
                break;

            case 9:
                choseFields(logic, gameGUI, fl, p, Color.cyan, false);
                break;

            case 10:
                gameGUI.showMessage("You got a get out of jail card, and will be able to get out of jail for free");;
                gameGUI.displayChance("You got a get out of jail card, and will be able to get out of jail for free");
                p.setGetOutOfJailCard(true);
                break;

            case 11:
                moveToAField(p,logic, gameGUI, 23, fl,false);
                break;

            case 14:
                receivesMoneyFromPlayers(p,pl,1, gameGUI);
                break;

            case 15:
                playerChoice = gameGUI.getUserButtons("Chose which color you want to move to (1) Pink field (2) Blue field", 1,2);
                if (playerChoice == 1)
                    choseFields(logic, gameGUI, fl, p, Color.pink, false);
                else
                    choseFields(logic, gameGUI, fl, p, Color.blue, false);
                break;

            case 16:
                gameGUI.showMessage("You get 2M from the bank");;
                gameGUI.displayChance("You get 2M from the bank");
                p.getAccount().deposit(2);
                break;

            case 17:
                choseFields(logic, gameGUI,fl,p,Color.red, true);
                break;

            case 18:
                moveToAField(p,logic, gameGUI,10,fl,true);
                break;
        }
    }
}
