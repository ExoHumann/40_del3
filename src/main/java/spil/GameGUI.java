
package spil;

import gui_fields.*;
import gui_main.GUI;

import static java.lang.Thread.sleep;

public class GameGUI {

    private GUI gui;
    private GUI_Field[] fields;
    public GUI_Player[] gui_players;
    private GUI_Car[] gui_cars;

    public GameGUI(GUI gui){
        this.gui = gui;
        this.fields = gui.getFields();
    }

    /**
     * Players are placed on a field and shown their balance
     * @param player gui players and - cars are made from the player length
     */
    public void addPlayers(Player[] player){
        gui_cars = new GUI_Car[player.length];
        gui_players = new GUI_Player[player.length];

        for (int i = 0; i < player.length; i++) {
            gui_cars[i] = new GUI_Car(player[i].getColor(), player[i].getColor(), GUI_Car.Type.UFO, GUI_Car.Pattern.FILL);
            gui_players[i] = new GUI_Player(player[i].getName(),0, gui_cars[i]);
            gui.addPlayer(gui_players[i]);
            fields[0].setCar(gui_players[i], true);
            gui_players[i].setBalance(1000);
        }
    }

    /**
     * Player is move 1 field at a time
     * @param prePos Previous position of the player
     * @param PNum  The player that are being moved
     * @param dice  Uses dice.getSum() to find the amount of fields it needs to move
     * @throws InterruptedException Uses sleep() to make a shot pause before moving again
     */
    public void fancyMoveGuiPlayer(int prePos, int PNum, Dice dice) throws InterruptedException {
        int dif = dice.getSum();
        int fieldLength = fields.length;
        for (int i = 0; i < dif ; i++) {
            int pos = (prePos + 1) % fieldLength;
        if (fields[prePos].hasCar(gui_players[PNum])) {
            fields[prePos].setCar(gui_players[PNum], false);
            fields[pos].setCar(gui_players[PNum], true);
            sleep(200);
            prePos = (prePos + 1) % fieldLength;
            }
        }
    }

    /**
     * Moves the player to the starting field 0
     * @param pl Used to find the position of the player that are being moved
     * @param PNum The player that are being moved
     */
    public void moveToStart(PlayerList pl, int PNum) {
        int prePos = pl.getPlayerList(PNum).getCurrentPosition();
        if (fields[prePos].hasCar(gui_players[PNum])) {
            fields[prePos].setCar(gui_players[PNum], false);
            fields[0].setCar(gui_players[PNum], true);
            pl.getPlayerList(PNum).setCurrentPosition(0);
        }
    }

    /**
     * Updates the balance that is shown on the screen
     * @param pl Used to get the players account
     * @param PNum The player that are being accessed
     */
    public void showBalance(PlayerList pl, int PNum){
        int balance = pl.getAccount(PNum).getBalance();
        gui_players[PNum].setBalance(balance);
    }


    public String setPlayerName(){ return gui.getUserString("Write player name: "); }

    public int setPlayerAmount(){ return gui.getUserInteger("Chose 2-6 players", 2, 6);}

    public void showDice(int dice1, int dice2){ gui.setDice(dice1,dice2); }

    public void rollDiceAction(Player[] player, int PNum){ gui.showMessage(player[PNum].getName() + " do you want to roll dice?"); }
}
