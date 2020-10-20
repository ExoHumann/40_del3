package spil;

import gui_fields.GUI_Car;
import gui_main.GUI;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        FieldList fl = new FieldList();

        Logic logic = new Logic();

        GUI gui = new GUI(board.createBoard(fl.getFields()));
        GameGUI gameGui = new GameGUI(gui);

        PlayerList pl = new PlayerList(2);
        gameGui.addPlayers(pl.getPlayersList());

        Dice dice = new Dice(0,0);

        pl.getPlayerList(1).move(5);
        logic.movePlayer(pl.getPlayerList(1), cDice);




    }
}