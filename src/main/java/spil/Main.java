package spil;

import gui_fields.GUI_Car;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        GameGUI gameGui = new GameGUI();

        GUI_Car car1 = new GUI_Car(Color.red,Color.red, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
        GUI_Car car2 = new GUI_Car(Color.blue,Color.blue, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);

        Player player1 = new Player(GameGUI.GetPlayerName(),0,car1);
        Player player2 = new Player(GameGUI.GetPlayerName(),0,car2);
        gameGui.AddPlayers(player1,player2);


        Dice cDice = new Dice(0,0);
        Dice pDice = new Dice(0,0);

        new Game(player1,player2,2,cDice, pDice);

    }
}