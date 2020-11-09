
package Controller;

import Model.Dice;
import Model.FieldList;
import Model.PlayerList;
import Translation.Translator;
import View.Board;
import View.GameGUI;
import gui_main.GUI;

import java.awt.*;

public class Game {

    static public Translator translation;
    private static final int minPlayers = 2;
    private static final int maxPlayers = 4;

    public void play(String local) throws InterruptedException {

        translation = new Translator(local);

        Board board = new Board();
        FieldList fl = new FieldList();

        Logic logic = new Logic();
        Chance chance = new Chance();

        GUI gui = new GUI(board.createBoard(fl), Color.WHITE);
        GameGUI gameGui = new GameGUI(gui);

        int playerAmount = gameGui.getUserButtons(Game.translation.getPlayerSelectAction(), minPlayers,maxPlayers);
        PlayerList pl = new PlayerList(playerAmount);

        Dice dice = new Dice(0,0);

        chance.Shuffle();
        chance.printDeck();

        for (int i = 0; i < playerAmount; i++) {
            String name = gameGui.getUserString(Game.translation.getPlayerNameAction());
            pl.getPlayerList(i).setName(name);
            pl.getAccount(i).setBalance(pl.getAccount(i).getStartingBalance(playerAmount));
        }

        gameGui.addPlayers(pl);

        int playerTurn = 0;
        int preTurn = 0;

        for (int i = 0; i < playerAmount; i++) {
            while(!logic.winCondition(pl)) {
                preTurn = playerTurn;

                logic.displayTakingTurn(pl, playerTurn);
                gameGui.showMessage(pl.getPlayerList(playerTurn).getName() + " " + Game.translation.getRollDiceAction());


                logic.movePlayer(pl, fl, dice.roll(), playerTurn);

                logic.diceInfo(pl, dice, playerTurn);

                gameGui.showDice(dice.getDie1(), dice.getDie2());
                gameGui.fancyMoveGuiPlayer(logic.prePos, playerTurn, dice.getSum());
                gameGui.showBalance(pl, playerTurn);

                if (logic.landedOnChance) {
                    chance.chance(pl, fl, playerTurn, logic, gameGui);
                    gameGui.showBalance(pl, playerTurn);
                }
                    if (logic.drawAnother) {
                        chance.chance(pl, fl, playerTurn, logic, gameGui);
                        gameGui.showBalance(pl, playerTurn);
                    }

                if (pl.getPlayerList(playerTurn).getInJail()) {
                    logic.movePlayer(pl, fl, fl.getSize() + 6 - logic.pos, playerTurn);
                    gameGui.moveToField(logic.pos, playerTurn, 6);
                }

                pl.getPlayerList(playerTurn).incrementTurn();
                logic.displayTurn(pl, playerTurn);
                playerTurn = (playerTurn + 1)%playerAmount;
            }
        }
        logic.findWinner(pl, preTurn);
        gameGui.showMessage(pl.getPlayerList(preTurn).getName() + " " + Game.translation.getWonTheGameString() + pl.getAccount(preTurn).getBalance());
        gui.close();
    }
}