package spil;

import gui_fields.GUI_Car;
import gui_main.GUI;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        GUI gui = new GUI();
        GameGUI gameGui = new GameGUI(gui);

        GUI_Car car1 = new GUI_Car(Color.red,Color.red, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
        GUI_Car car2 = new GUI_Car(Color.blue,Color.blue, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);

        FieldList fl = new FieldList();
        fl.getAllFields();

        // Player player1 = new Player(GameGUI.setPlayerName(),Color.RED);
        // Player player2 = new Player(GameGUI.setPlayerName(),Color.blue);
        // gameGui.addPlayers(player1,player2);


        Dice cDice = new Dice(0,0);
        Dice pDice = new Dice(0,0);

       // new Game(player1,player2,2,cDice, pDice);

    }
}