
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
    private static final int minPlayers = 2;
    private static final int maxPlayers = 4;
    private final FieldList fl;
    private final Board board;
    private final BuyingController buyingController;
    private final Logic logic;
    private final ChanceController chance;
    private final GUI gui;
    private final GameGUI gameGUI;
    private PlayerList pl;
    private final Dice dice;
    private Player p;
    public int prePos;
    public int pos;

    public Game(String local) {
        translation = new Translator(local);
        fl = new FieldList();
        board = new Board(fl);
        gui = new GUI(board.createBoard(fl), Color.WHITE);
        gameGUI = new GameGUI(gui);
        buyingController = new BuyingController();
        logic = new Logic();
        chance = new ChanceController();
        dice = new Dice(0, 0);
    }

    public void play() throws InterruptedException {

        gameSetup();

        pl.setCurrentPlayer(0);

        while (!logic.winCondition(pl)) {
            p = pl.getCurrentPlayer();

            if (p.isInJail()){ takeJailTurn(); }

            takeTurn();

            if(p.isInJail()){
                gameGUI.showMessage("You will now go to jail");
                gameGUI.moveToField(p,6);
                pos = 6; p.setCurrentPosition(pos); }

            if (logic.landedOnChance) { }
            if (logic.drawAnother) { }

            p.incrementTurn();logic.displayTurn(p);
            pl.getNextPlayer();
        }
        //logic.findWinner(pl, playerTurn);
        //gameGUI.showMessage(pl.getPlayerList(playerTurn).getName() + " " + Game.translation.getWonTheGameString() + pl.getAccount(playerTurn).getBalance());
        gui.close();
    }

    public void takeJailTurn() throws InterruptedException {
        p.setInJail(false);
        String yes = "Yes"; String no = "No";
        if (p.isGetOutOfJailCard()){
            String choice = gui.getUserSelection("You have a get out of Jail card do you wnat to use it", yes, no);
            if (yes.equals(choice)){
                takeTurn();
            } else if (no.equals(choice)) pl.getNextPlayer();
        }  else {
            String choice1 = gui.getUserSelection("Do you want to pay 1M for release", yes, no);
            if (yes.equals(choice1)) {
                p.getAccount().withdraw(1);
                takeTurn();
            } else if (no.equals(choice1)) pl.getNextPlayer();
        }
    }


    public void rollNMove(){
        prePos = p.getCurrentPosition();
        p.move(dice.roll(), fl);
        logic.diceInfo(p,dice);
        pos = p.getCurrentPosition(); p.setCurrentPosition(pos);
        logic.landedOn(p,fl);
    }
    public void updateGUIMove() throws InterruptedException {
        gameGUI.showDice(dice.getDie1(), dice.getDie2());
        gameGUI.fancyMoveGuiPlayer(prePos, pl.getCurrentPlayer(), dice.getSum());
    }
    public void updateGUIBalanceAndFieldColor(){
        gameGUI.updateFieldBuy(fl);
        gameGUI.showBalance(pl);
    }
    public void takingTurnMessage(){
        logic.displayTakingTurn(p);
        gameGUI.showMessage(p.getName() + " " + Game.translation.getRollDiceAction());
    }

    public void takeTurn() throws InterruptedException {
        takingTurnMessage();
        rollNMove();
        updateGUIMove();
        updateGUIBalanceAndFieldColor();
    }
    public void gameSetup(){
        int playerAmount = gameGUI.getUserButtons(Game.translation.getPlayerSelectAction(), minPlayers, maxPlayers);
        pl = new PlayerList(playerAmount);
        for (int i = 0; i < playerAmount; i++) {
            String name = gameGUI.getUserString(Game.translation.getPlayerNameAction());
            pl.getPlayerList(i).setName(name);
            pl.getAccount(i).setBalance(pl.getAccount(i).getStartingBalance(playerAmount));
        }
        chance.Shuffle();
        chance.printDeck();
        gameGUI.addPlayers(pl);
    }

}