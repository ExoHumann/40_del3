
package spil;

import gui_fields.*;
import gui_main.GUI;

public class GameGUI {

    private GUI gui;
    private GUI_Field[] fields;
    public GUI_Player[] gui_players;
    private GUI_Car[] gui_cars;

    public GameGUI(GUI gui){
        this.gui = gui;
        this.fields = gui.getFields();
    }

    public GUI_Player[] getGui_players() { return gui_players; }

    //Players are added to the game and they are placed on the board
    public void addPlayers(Player[] player){
        gui_cars = new GUI_Car[player.length];
        gui_players = new GUI_Player[player.length];

        for (int i = 0; i < player.length; i++) {
            gui_cars[i] = new GUI_Car(player[i].getColor(), player[i].getColor(), GUI_Car.Type.TRACTOR, GUI_Car.Pattern.FILL);
            gui_players[i] = new GUI_Player(player[i].getName(),0, gui_cars[i]);
            gui.addPlayer(gui_players[i]);
            fields[0].setCar(gui_players[i], true);
        }
    }

    public void moveGuiPlayers(int prePos, int pos, int PNum){
        if (fields[prePos].hasCar(gui_players[PNum])) {
            fields[prePos].setCar(gui_players[PNum], false);
            fields[pos].setCar(gui_players[PNum], true);
        }
    }

    public void moveToStart(PlayerList pl, int PNum) {
        int prePos = pl.getPlayerList(PNum).getCurrentPosition();
        if (fields[prePos].hasCar(gui_players[PNum])) {
            fields[prePos].setCar(gui_players[PNum], false);
            fields[0].setCar(gui_players[PNum], true);
            pl.getPlayerList(PNum).setCurrentPosition(0);
        }
    }



    public String setPlayerName(){ return gui.getUserString("Write player name: "); }

    public int setPlayerAmount(){ return gui.getUserInteger("Chose 2-4 players", 2, 4);}

    public void showDice(int dice1, int dice2){ gui.setDice(dice1,dice2); }

    public void rollDiceAction(Player[] player, int PNum){ gui.showMessage(player[PNum].getName() + " do you want to roll dice?"); }

    public void showBalance(PlayerList pl, int PNum){
        int balance = pl.getAccount(PNum).getBalance();
        gui_players[PNum].setBalance(balance);
    }


}
