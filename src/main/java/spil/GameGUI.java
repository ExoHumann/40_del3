
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
        gui_cars = new GUI_Car[player.length];
        gui_players = new GUI_Player[player.length];

        for (int i = 0; i < player.length; i++) {
            gui_cars[i] = new GUI_Car(player[i].getColor(), player[i].getColor(), GUI_Car.Type.UFO, GUI_Car.Pattern.FILL);
            gui_players[i] = new GUI_Player(setPlayerName(),0, gui_cars[i]);
            gui.addPlayer(gui_players[i]);
            fields[0].setCar(gui_players[i], true);
        }
    }


    public String setPlayerName(){ return gui.getUserString("Write player name: "); }


}
