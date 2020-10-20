package spil;

import gui_fields.GUI_Car;
import gui_main.GUI;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        FieldList fl = new FieldList();

        GUI gui = new GUI(board.createBoard(fl.getFields()));
        GameGUI gameGui = new GameGUI(gui);



        PlayerList pl = new PlayerList(1);
        gameGui.addPlayers(pl.getPlayersList());

        GUI_Car car1 = new GUI_Car(Color.red,Color.red, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
        GUI_Car car2 = new GUI_Car(Color.blue,Color.blue, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);

        Dice cDice = new Dice(0,0);
        Dice pDice = new Dice(0,0);

       // new Game(player1,player2,2,cDice, pDice);

    }
}