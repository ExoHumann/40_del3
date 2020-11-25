
package Controller;

import Model.Dice;
import Model.FieldList;
import Model.PlayerList;
import Model.Playerlist.Player;
import Translation.Translator;
import View.Board;
import View.GameGUI;
import gui_main.GUI;

import java.awt.*;

public class Game {

    static public Translator translation;
    protected static final int minPlayers = 2;
    protected static final int maxPlayers = 4;
    protected final FieldList fl;
    protected final Board board;
    protected final BuyingController buyingController;
    protected final Logic logic;
    protected final ChanceController chance;
    protected final GUI gui;
    protected final GameGUI gameGUI;
    protected PlayerList pl;
    protected final Dice dice;
    protected Player p;

    public Game() {
        translation = new Translator("en");
        fl = new FieldList();
        board = new Board(fl);
        gui = new GUI(board.createBoard(fl), Color.WHITE);
        gameGUI = new GameGUI(gui);
        buyingController = new BuyingController();
        logic = new Logic();
        chance = new ChanceController();
        dice = new Dice(0, 0);
        gameSetup();
    }


    public void play() {
        pl.setCurrentPlayer(0);

        while (!logic.winCondition(pl)) {
            p = pl.getCurrentPlayer();

            if (p.isInJail()) {
                takeJailTurn();
            } else {
                takeTurn();
            }

            if (logic.landedOnChance) {
                logic.landedOnChance = false;
                takeChance();
            }
            if (logic.drawAnother) {
                takeChance();
                logic.drawAnother = false;
            }

            if(p.isInJail()){
                gameGUI.showMessage(p.getName() + " You will now go to jail");
                p.setCurrentPosition(6);
                gameGUI.moveToField(p);
            }

            if(p.buyNextPossibleField){
                gameGUI.showMessage(p.getName() + " Will now buy the next possible field");
                buyingController.buyNextPossibleField(p,fl);
                gameGUI.moveToField(p);
                updateGUIBalanceAndFieldColor();
            }

            p.incrementTurn();logic.displayTurn(p);
            pl.getNextPlayer();
        }
        //logic.findWinner(pl, playerTurn);
        //gameGUI.showMessage(pl.getPlayerList(playerTurn).getName() + " " + Game.translation.getWonTheGameString() + pl.getAccount(playerTurn).getBalance());
        gui.close();
    }

    public void takeJailTurn() {
        String yes = "Yes"; String no = "No";
        p.setInJail(false);
        if (p.isGetOutOfJailCard()){
            String choice = gui.getUserButtonPressed(p.getName() + "You have a get out of Jail card do you want to use it", yes, no);

            if (choice.equals(yes)){
                p.setGetOutOfJailCard(false);
                takeTurn();
                return;
            }
        }
        String choice1 = gui.getUserButtonPressed(p.getName() + "Do you want to pay 1M for release", yes, no );

        if (choice1.equals(yes)){
            p.getAccount().withdraw(1);
            updateGUIBalanceAndFieldColor();
            takeTurn();
        }
    }
    public void takeChance(){
        gameGUI.showMessage(p.getName() + " will now draw a chance card");
        chance.chance(p,pl,fl,logic,gameGUI);
        passStartMoney();
        updateGUIBalanceAndFieldColor();
    }
    public void takeTurn() {
        takingTurnMessage();
        moveAndLandOn();
        updateGUIMove();
        passStartMoney();
        updateGUIBalanceAndFieldColor();
    }
    public void moveAndLandOn(){
        p.move(dice.roll(), fl);
        logic.diceInfo(p,dice);
        logic.landedOn(p,fl);
    }
    public void updateGUIMove() {
        gameGUI.showDice(dice);
        gameGUI.fancyMoveGuiPlayer(p, dice.getSum());
    }
    public void updateGUIBalanceAndFieldColor(){
        gameGUI.updateFieldBuy(fl);
        gameGUI.showBalance(pl);
    }
    public void takingTurnMessage(){
        logic.displayTakingTurn(p);
        gameGUI.showMessage(p.getName() + " " + Game.translation.getRollDiceAction());
    }
    public void gameSetup(){
        int playerAmount = gameGUI.getUserButtons(Game.translation.getPlayerSelectAction(), minPlayers, maxPlayers);
        pl = new PlayerList(playerAmount);
        for (int i = 0; i < playerAmount; i++) {
            String name = gameGUI.getUserString(Game.translation.getPlayerNameAction());
            pl.getPlayerList(i).setName(name);
            pl.getAccount(i).setBalance(pl.getAccount(i).getStartingBalance(playerAmount));
        }
        chance.shuffle();
        chance.printDeck();
        gameGUI.addPlayers(pl);
    }
    public void passStartMoney(){
        if (p.getPreviousPosition() > p.getCurrentPosition()){
            p.getAccount().deposit(2);
        }
    }
}