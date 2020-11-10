
package View;

import Model.FieldList;
import Model.PlayerList;
import Model.Playerlist.Player;
//import com.sun.jdi.IntegerValue;
import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;

import static gui_fields.GUI_Car.Pattern.*;
import static gui_fields.GUI_Car.Type.*;
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

    public void updateFieldBuy(PlayerList pl,FieldList fl){
        for (int i = 0; i <fields.length ; i++) {
            GUI_Ownable ownable = (GUI_Ownable) fields[i];
            int owner = fl.getField(i).getOwner();
            if (!(fl.getField(i).getOwner() == 0)) {
                ownable.setOwnerName(pl.getPlayerList(owner-1).getName());
                ownable.setBorder(pl.getPlayerList(owner-1).getColor());
                ownable.setRentLabel("\nRent: " + fl.getField(i).getRent());
            }
        }
    }

    GUI_Car.Type[] cars = {CAR, RACECAR, TRACTOR, UFO};
    /**
     * Players are placed on a field and shown their balance
     * @param pl gui players and - cars are made from the player length
     */
    public void addPlayers(PlayerList pl){
        gui_cars = new GUI_Car[pl.getPlayerAmount()];
        gui_players = new GUI_Player[pl.getPlayerAmount()];

        for (int i = 0; i < pl.getPlayerAmount(); i++) {
            Player player = pl.getPlayerList(i);
            gui_cars[i] = new GUI_Car(player.getColor(), player.getColor(), cars[i%pl.getPlayerAmount()], FILL);
            gui_players[i] = new GUI_Player(player.getName(),0, gui_cars[i]);
            gui.addPlayer(gui_players[i]);
            fields[0].setCar(gui_players[i], true);
            gui_players[i].setBalance(pl.getAccount(i).getStartingBalance(pl.getPlayerAmount()));
        }
    }

    /**
     * Player is move 1 field at a time
     * @param prePos Previous position of the player
     * @param PNum  The player that are being moved
     * @param dif  The amount of fields it will move uses dice.getSum() to find the amount of fields it needs to move
     * @throws InterruptedException Uses sleep() to make a shot pause before moving again
     */
    public void fancyMoveGuiPlayer(int prePos, int PNum, int dif) throws InterruptedException {
        int fieldLength = fields.length;
        for (int i = 0; i < dif ; i++) {
            int pos = (prePos + 1) % fieldLength;
        if (fields[prePos].hasCar(gui_players[PNum])) {
            fields[prePos].setCar(gui_players[PNum], false);
            fields[pos].setCar(gui_players[PNum], true);
            sleep(170);
            prePos = (prePos + 1) % fieldLength;
            }
        }
    }

    /**
     * Moves the player to the starting field 0
     * @param moveToPos Used to find the position of the player that are being moved
     * @param PNum The player that are being moved
     */
    public void moveToField(int prePos, int PNum, int moveToPos) throws InterruptedException {
        int dif = (fields.length + moveToPos - prePos-1)%fields.length+1;
        for (int i = 0; i < dif ; i++) {
            moveToPos = (prePos + 1) % fields.length;
        if (fields[prePos].hasCar(gui_players[PNum])) {
            fields[prePos].setCar(gui_players[PNum], false);
            fields[moveToPos].setCar(gui_players[PNum], true);
            sleep(170);
            prePos = (prePos + 1) % fields.length;
            }
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

    public void showDice(int dice1, int dice2) {
        new Thread(() -> {
            for (int rotation = 0; rotation <= 450; ++rotation) {
                gui.setDice(dice1, rotation, 4, 1, dice2, rotation, 5, 1);
                try {
                    sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void showMessage(String message){ gui.showMessage(message); }

    public String getUserString(String message){ return gui.getUserString(message); }

    public int getUserButtons(String message, int min, int max){
        String[] options = new String[max-min+1];

        for (int i = min; i <= max; i++) {
            options[i-min] = String.valueOf(i);
        }
        return Integer.parseInt(gui.getUserButtonPressed(message, options));
    }

    public int getUserDropDown(String message, int min, int max){
        String[] options = new String[max-min+1];

        for (int i = min; i <= max; i++) {
            options[i-min] = String.valueOf(i);
        }
        return Integer.parseInt(gui.getUserSelection(message, options));
    }

    public void displayChance(String message){
        gui.setChanceCard(message);
        gui.displayChanceCard();
        gui.displayChanceCard(message);
    }

    public void closeGame() { gui.close(); }
}
