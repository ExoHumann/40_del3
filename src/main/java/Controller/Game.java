
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
    private static final int minPlayers = 2;
    private static final int maxPlayers = 4;
    private final FieldList fl;
    private final Board board;
    private final BuyingController buyingController;
    private final Logic logic;
    //private final ChanceController chance;
    private final GUI gui;
    private final GameGUI gameGUI;
    private final PlayerList pl;
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
        //chance = new ChanceController();
        dice = new Dice(0, 0);

        int playerAmount = gameGUI.getUserButtons(Game.translation.getPlayerSelectAction(), minPlayers, maxPlayers);
        pl = new PlayerList(playerAmount);

        for (int i = 0; i < playerAmount; i++) {
            String name = gameGUI.getUserString(Game.translation.getPlayerNameAction());
            pl.getPlayerList(i).setName(name);
            pl.getAccount(i).setBalance(pl.getAccount(i).getStartingBalance(playerAmount));
        }

        //chance.Shuffle();
        //chance.printDeck();
        gameGUI.addPlayers(pl);
    }

    public void play() throws InterruptedException {
        pl.setCurrentPlayer(0);

        while (!logic.winCondition(pl)) {
            p = pl.getCurrentPlayer();

            takingTurnMessage();
            rollNMove();
            logic.landedOn(p, fl);
            updateGUI();

            p.incrementTurn();logic.displayTurn(p);
            pl.getNextPlayer();
        }
        //logic.findWinner(pl, playerTurn);
        //gameGUI.showMessage(pl.getPlayerList(playerTurn).getName() + " " + Game.translation.getWonTheGameString() + pl.getAccount(playerTurn).getBalance());
        gui.close();
    }
    public void rollNMove(){
        prePos = p.getCurrentPosition();
        p.move(dice.roll(), fl);
        logic.diceInfo(p,dice);
        pos = p.getCurrentPosition();
    }
    public void updateGUI() throws InterruptedException {
        gameGUI.showDice(dice.getDie1(), dice.getDie2());
        gameGUI.fancyMoveGuiPlayer(prePos, pl.getCurrentPlayer(), dice.getSum());
        gameGUI.updateFieldBuy(fl);
        for (int j = 0; j < pl.getPlayerAmount(); j++) {
            gameGUI.showBalance(p);
        }
    }
    public void takingTurnMessage(){
        logic.displayTakingTurn(p);
        gameGUI.showMessage(p.getName() + " " + Game.translation.getRollDiceAction());
    }
}