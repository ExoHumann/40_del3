package spil;

import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Street;
import gui_main.GUI;

import java.awt.*;

public class Main {

    public static void main(String[] args) {


        //Create a board and fill it with fields
        GUI_Field[] fields = new GUI_Field[40];
        for(int i =0;i<40;i++){
            fields[i]=new GUI_Street(String.valueOf(i),"","","",Color.yellow,Color.red);
        } GUI gameGUI = new GUI(fields,Color.green);

        GUI_Car car1 = new GUI_Car(Color.red,Color.red, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
        GUI_Car car2 = new GUI_Car(Color.blue,Color.blue, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);

        //Create the player and set him values like name score and car and add them to the board.
        String playerName = gameGUI.getUserString("Indtast spiller 1");
        Player player = new Player(playerName, 0, car1);
        String computerName = gameGUI.getUserString("Indtast spiller 2");
        Player computer = new Player(computerName, 0, car2);
        gameGUI.addPlayer(player);
        gameGUI.addPlayer(computer);
        //Place the players car on the first field.
        fields[0].setCar(player, true);
        fields[0].setCar(computer, true);

        // Create two dice
        Dice cDice = new Dice(0,0);
        Dice pDice = new Dice(0,0);

        // Create new game from game constructor in game class
        new Game(gameGUI, player, computer, 10, cDice, pDice);
    }

}
