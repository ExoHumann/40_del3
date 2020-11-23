
package View;

import Model.Dice;
import Model.FieldList;
import Model.Fields.Ownable;
import Model.PlayerList;
import Model.Playerlist.Player;
import gui_fields.*;
import gui_main.GUI;

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

    public void updateFieldBuy(FieldList fl){
        for (int i = 0; i <fields.length ; i++) {

            if (fields[i] instanceof GUI_Street){

                GUI_Ownable ownable = (GUI_Ownable) fields[i];
                Ownable ownableField = (Ownable) fl.getField(i);

           Player owner = ownableField.getOwner();

            if (ownableField.getOwner() != null) {
                ownable.setOwnerName(owner.getName());
                ownable.setBorder(owner.getColor());
                }
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
     * @param dif  The amount of fields it will move uses dice.getSum() to find the amount of fields it needs to move
     * @throws InterruptedException Uses sleep() to make a shot pause before moving again
     */
    public void fancyMoveGuiPlayer(int prePos, Player p, int dif) {
        int fieldLength = fields.length;
        int PNum = p.getNum();
        for (int i = 0; i < dif ; i++) {
            int pos = (prePos + 1) % fieldLength;
        if (fields[prePos].hasCar(gui_players[PNum])) {
            fields[prePos].setCar(gui_players[PNum], false);
            fields[pos].setCar(gui_players[PNum], true);
            try {
                sleep(170);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            prePos = (prePos + 1) % fieldLength;
            }
        }
    }

    /**
     * Moves the player to the starting field 0
     * @param moveToPos Used to find the position of the player that are being moved
     */
    public void moveToField(Player p, int moveToPos) {
        int pos = p.getCurrentPosition();
        int dif = (fields.length + moveToPos - pos-1)%fields.length+1;
        int PNum = p.getNum();
        for (int i = 0; i < dif ; i++) {
            moveToPos = (pos + 1) % fields.length;
        if (fields[pos].hasCar(gui_players[PNum])) {
            fields[pos].setCar(gui_players[PNum], false);
            fields[moveToPos].setCar(gui_players[PNum], true);
            try {
                sleep(170);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pos = (pos + 1) % fields.length;
            }
        }
    }

    /**
     * Updates the balance that is shown on the screen
     */
    public void showBalance(PlayerList pl){
        for (int i = 0; i < pl.getPlayerAmount() ; i++) {
            Player p = pl.getPlayerList(i);
            int balance = p.getAccount().getBalance();
            gui_players[i].setBalance(balance);
        }
    }

    public void showDice(Dice dice) {
        new Thread(() -> {
            for (int rotation = 0; rotation <= 450; ++rotation) {
                gui.setDice(dice.getDie1(), rotation, 4, 1, dice.getDie2(), rotation, 5, 1);
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
        for (int i = min; i <= max; i++)
            options[i - min] = String.valueOf(i);
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
