
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
    private final ChanceController chance;
    private final GUI gui;
    private final GameGUI gameGUI;
    private final PlayerList pl;
    private final Dice dice;

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

    public void play() throws InterruptedException {
        int playerTurn = 0;
        int playerAmount = pl.getPlayerAmount();

        while (!logic.winCondition(pl)) {
            Player player = pl.getPlayerList(playerTurn);

            logic.displayTakingTurn(pl, playerTurn);
            gameGUI.showMessage(player.getName() + " " + Game.translation.getRollDiceAction());

            logic.movePlayer(pl, fl, dice.roll(), playerTurn);

            logic.diceInfo(pl, dice, playerTurn);

            gameGUI.showDice(dice.getDie1(), dice.getDie2());
            gameGUI.fancyMoveGuiPlayer(logic.prePos, playerTurn, dice.getSum());
            gameGUI.showBalance(pl, playerTurn);
            gameGUI.updateFieldBuy(pl, fl);

            //if (logic.landedOnChance) {
                chance.chance(pl, fl, playerTurn, logic, gameGUI);
            //}
            chance.printDeck();
            if (logic.drawAnother) {
                chance.chance(pl, fl, playerTurn, logic, gameGUI);
            }

            if (player.buyNextPossibleField) {
                gameGUI.showMessage("Move to next possible field");
                buyingController.buyNextPossibleField(pl, fl, playerTurn);
                gameGUI.moveToField(logic.prePos, playerTurn, logic.moveAmount(logic.pos, fl));
            }

            if (player.getInJail()) {
                gameGUI.moveToField(logic.pos, playerTurn, 6);
                pl.getPlayerList(playerTurn).setInJail(false);
            }

            gameGUI.updateFieldBuy(pl, fl);

            for (int j = 0; j < playerAmount; j++) {
                gameGUI.showBalance(pl, j);
            }

            player.incrementTurn();
            logic.displayTurn(pl, playerTurn);
            playerTurn = (playerTurn + 1) % playerAmount;

        }
        logic.findWinner(pl, playerTurn);
        gameGUI.showMessage(pl.getPlayerList(playerTurn).getName() + " " + Game.translation.getWonTheGameString() + pl.getAccount(playerTurn).getBalance());
        gui.close();
    }
}