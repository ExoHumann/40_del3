package spil;

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class Logic {
    private GUI_Field[] fields;
    private Player[] players;
    private Dice dice;
    private int PNum;
    private GUI_Player gui_player;

    public Logic(){

    }
/*
    //Updates the roll and position of the dice
    public void movePlayer(Player[] players, Dice dice) {
        this.players = players;
        this.dice = dice;
        int prePos = players[PNum].getCurrentPosition();
        //gui.showMessage("Roll The Dice: " + players[PNum].getName() + "'s Turn");
        players[PNum].move(dice.roll());
        int pos = players[PNum].getCurrentPosition();

        if (fields[prePos].hasCar(gui_player)) {
            //gui.setDice(dice.getDie1(), dice.getDie2());
            fields[prePos].setCar(gui_player, false);
            fields[pos].setCar(gui_player, true);
        }
    }

    public void moveToStart(Player player) {
        int prePos = player.getCurrentPosition();
        if (fields[prePos].hasCar(gui_player)) {
            fields[prePos].setCar(gui_player, false);
            fields[0].setCar(gui_player, true);
            player.setCurrentPosition(0);
        }
    }
*/
}
