
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

import static gui_tests.TestRunExampleGame.sleep;

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
    public int prePos;
    public int pos;

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


    public void play() throws InterruptedException {
        pl.setCurrentPlayer(0);

        while (!logic.winCondition(pl)) {
            p = pl.getCurrentPlayer();

            if (p.isInJail()) {
                takeJailTurn();
            } else {
                takeTurn();
            }

            if(p.isInJail()){
                gameGUI.showMessage(p.getName() + " You will now go to jail");
                gameGUI.moveToField(p,6);
                pos = 6; p.setCurrentPosition(pos);
            }

            if (logic.landedOnChance) {

            }
            if (logic.drawAnother) { }

            p.incrementTurn();logic.displayTurn(p);
            pl.getNextPlayer();
        }
        //logic.findWinner(pl, playerTurn);
        //gameGUI.showMessage(pl.getPlayerList(playerTurn).getName() + " " + Game.translation.getWonTheGameString() + pl.getAccount(playerTurn).getBalance());
        gui.close();
    }

    public void takeJailTurn() throws InterruptedException {
        String yes = "Yes"; String no = "No";
        p.setInJail(false);
        if (p.isGetOutOfJailCard()){
            String choice = gui.getUserButtonPressed(p.getName() + "You have a get out of Jail card do you wnat to use it", yes, no);

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
    public void takeTurn() throws InterruptedException {
        takingTurnMessage();
        rollNMove();
        updateGUIMove();
        passStartMoney();
        updateGUIBalanceAndFieldColor();
    }
    public void rollNMove(){
        prePos = p.getCurrentPosition();
        p.move(dice.roll(), fl);
        logic.diceInfo(p,dice);
        pos = p.getCurrentPosition(); p.setCurrentPosition(pos);
        logic.landedOn(p,fl);
    }
    public void updateGUIMove() throws InterruptedException {
        gameGUI.showDice(dice);
        gameGUI.fancyMoveGuiPlayer(prePos, p, dice.getSum());
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
        chance.init();
        chance.printDeck();
        gameGUI.addPlayers(pl);
    }
    public void passStartMoney(){
        if (prePos > pos){
            p.getAccount().deposit(2);
        }
    }
}