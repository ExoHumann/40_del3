package spil;

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class Logic {


    private GUI_Field[] fields;
    private Dice dice;
    public GUI_Player[] gui_players;
    private Player[] players;
    public Logic(){

    }

    private void diceInfo(PlayerList pl, Dice dice) {
      //  System.out.println(pl.getPlayerList(PNum).getName() + " " + dice.getDie1() + "+" + dice.getDie2() + "=" + dice.getSum() + " Position = " + pl.getPlayerList(PNum).getName() + " Balance: " );
    }


    //Updates the roll and position of the dice
    public void movePlayer(PlayerList pl, FieldList fl, GUI_Player[] gui_players, Dice dice, int PNum) {
        this.players = pl.getPlayersList();
        this.dice = dice;

        System.out.println("Your turn to roll the dice " + gui_players[PNum].getName());
        int prePos = players[PNum].getCurrentPosition();
        System.out.println("Previous position = " +prePos);
        players[PNum].move(dice.roll());
        System.out.println("Dice Result " + dice.getDie1() + " + " + dice.getDie2() + " = " + dice.getSum());
        int pos = players[PNum].getCurrentPosition();
        System.out.println("You landed on field: " + pos + " \n The price of this field is " + fl.getField(pos).getPrice());

/*        if (fields[prePos].hasCar(gui_players[PNum])) {
            fields[prePos].setCar(gui_players[PNum], false);
            fields[pos].setCar(gui_players[PNum], true);
        }

 */

    }

/*
    public void moveToStart(PlayerList pl, int PNum) {
        int prePos = players[PNum].getCurrentPosition();
        if (fields[prePos].hasCar(gui_players[PNum])) {
            fields[prePos].setCar(gui_players[PNum], false);
            fields[0].setCar(gui_players[PNum], true);
            players[PNum].setCurrentPosition(0);
        }
    }

 */
}
