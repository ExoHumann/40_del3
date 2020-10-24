package spil;

import gui_fields.GUI_Car;
import gui_main.GUI;

import java.awt.*;

import static gui_tests.TestRunExampleGame.sleep;

public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        FieldList fl = new FieldList();

        Logic logic = new Logic();

        GUI gui = new GUI(board.createBoard(fl.getFields()));
        GameGUI gameGui = new GameGUI(gui);

        PlayerList pl = new PlayerList(gameGui.PNum());
        gameGui.addPlayers(pl.getPlayersList());

        Dice dice = new Dice(0,0);
/*
        public void movePlayer() {
            int prePos = pl.getPlayerList(1).getCurrentPosition();
            gui.showMessage("Roll The Dice: " + pl.getPlayerList(PNum).getName() + "'s Turn");
            pl.getPlayerList(1).move(dice.roll());
            int pos = pl.getPlayerList(1).getCurrentPosition();



            if (fields[prePos].hasCar(gui_player)) {
                gui.setDice(dice.getDie1(), dice.getDie2());
                fields[prePos].setCar(gui_player, false);
                fields[pos].setCar(gui_player, true);
            }

             */
        }
    }
