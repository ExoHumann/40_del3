package spil;

import gui_fields.*;
import gui_main.GUI;
import java.awt.*;

public class GameGUI {

    static GUI gui;
    static GUI_Field[] fields;
    static Player player1;
    static Player player2;

    public GameGUI(){
        fields = new GUI_Field[40];

        GUI_Street street = new GUI_Street(); //Create new empty street tile

        //Populate the entire fields array with street tile
        for(int i =0;i<40  ;i++){
            fields[i]=new GUI_Street(String.valueOf(i),"","","",Color.yellow,Color.black);
        }

        //Set the subText of the first field to "start"
        fields[0].setSubText("Start");

        //Make the GUI with the created fields array and background color of green and return gui;
        GameGUI.gui = new GUI(fields,Color.cyan);

    }

    //Players are added to the game and they are placed on the board
    public void addPlayers(Player player1, Player player2){
        GameGUI.player1 = player1;
        GameGUI.player2 = player2;
        gui.addPlayer(player1);
        gui.addPlayer(player2);
        fields[0].setCar(player1, true);
        fields[0].setCar(player2, true);
    }
    //Moves the player around the board
    public static void movesPlayer(Player player, Dice dice) {
        int prePos = player.getCurrentPosition();
        gui.showMessage("Roll The Dice: " + player.getName() + "'s Turn");
        player.move(dice.roll());
        player.setBalance(player.getBalance() + dice.getSum());

        int pos = player.getCurrentPosition();
        if (fields[prePos].hasCar(player)) {
            gui.setDice(dice.getDice1(), dice.getDice2());
            fields[prePos].setCar(player, false);
            fields[pos].setCar(player, true);
        }
    }

    public static void movesToStart(Player player) {
        int prePos = player.getCurrentPosition();
        if (fields[prePos].hasCar(player)) {
            fields[prePos].setCar(player, false);
            fields[0].setCar(player, true);
            player.setBalance(0);
            player.setCurrentPosition(0);
            player.setScore(0);
        }
    }

    public static String getPlayerName(){ return gui.getUserString("Write player name: "); }

}