
package spil;

import gui_fields.*;
import gui_main.GUI;

public class GameGUI {

    private GUI gui;
    private GUI_Field[] fields;
    private GUI_Player[] gui_players;
    private GUI_Car[] gui_cars;

    public GameGUI(GUI gui){
        this.gui = gui;
        this.fields = gui.getFields();
    }

    //Players are added to the game and they are placed on the board
    public void addPlayers(Player[] player){

        for (int i = 0; i < player.length; i++) {
            gui_cars[i] = new GUI_Car(player[i].getColor(), player[i].getColor(), GUI_Car.Type.UFO, GUI_Car.Pattern.FILL);
            gui_players[i] = new GUI_Player(player[i].getName(),0, gui_cars[i]);
            gui.addPlayer(gui_players[i]);
            fields[0].setCar(gui_players[i], true);
        }

    }

    //Updates the roll and position of the dice
    public void movesPlayer(Player player, GUI_Player gui_player, Dice dice) {
        int prePos = player.getCurrentPosition();
        gui.showMessage("Roll The Dice: " + player.getName() + "'s Turn");
        player.move(dice.roll());
        int pos = player.getCurrentPosition();

        if (fields[prePos].hasCar(gui_player)) {
            gui.setDice(dice.getDie1(), dice.getDie2());
            fields[prePos].setCar(gui_player, false);
            fields[pos].setCar(gui_player, true);
        }
    }

    public void movesToStart(Player player, GUI_Player gui_player) {
        int prePos = player.getCurrentPosition();
        if (fields[prePos].hasCar(gui_player)) {
            fields[prePos].setCar(gui_player, false);
            fields[0].setCar(gui_player, true);
            player.setCurrentPosition(0);
        }
    }

    public String setPlayerName(){ return gui.getUserString("Write player name: "); }

}
