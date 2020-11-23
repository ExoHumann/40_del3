package Controller;

import Model.Dice;
import Model.FieldList;
import Model.PlayerList;
import Model.Playerlist.*;

public class Logic {

    boolean landedOnChance;
    boolean drawAnother;

    private BuyingController buyingController;

    public Logic() {
        this.buyingController = new BuyingController();
    }

    /**
     * Updates the roll and position of the dice
     * Moves the player outside of the GUI.
     * Manages the balance of the player
     * @param p Which player is taking a turn
     * @param fl FieldList used to access the price of the fields
     */
    public void landedOn(Player p, FieldList fl) {

        int pos = p.getCurrentPosition();
        //Player crossed start
        /*if (prePos > pos){
            p.getAccount().deposit(2);
        }*/

        switch (pos) {
            case 0: case 6: case 12:
                p.setInJail(true);
                break;

            case 3: case 9: case 15: case 21:
                landedOnChance = true;
                p.setInJail(true);
                break;

            case 18:
                p.setInJail(true);
                break;

            default:
                buyingController.buyField(p,fl);
        }
                System.out.printf(Game.translation.getLandedString(),
                p.getName(), pos, fl.getField(pos).getTitle(), fl.getField(pos).getPrice());
    }

    public int moveAmount(Player p, FieldList fl, int moveToPos) {
        return (fl.getSize() + moveToPos - p.getCurrentPosition() - 1) % fl.getSize() + 1;
    }

        /**
         * Describes the win condition of the game if a player has 3000 balance
         * @param pl player list used to access accounts and check all counts
         * @return Returns if the condition is met or no
         */
    public boolean winCondition(PlayerList pl) {
        boolean winCondition = false;
        for (int i = 0; i <pl.getPlayerAmount() ; i++) {
            if (pl.getAccount(i).getBalance() <= 0) winCondition = true;
        }
        return winCondition;
    }

    public void findWinner(Player p){
        System.out.println(p.getName() + Game.translation.getWonString() + p.getAccount().getBalance());
    }

    public void diceInfo(Player p, Dice dice) {
        System.out.printf(Game.translation.getDiceInfo() +"\n",p.getName(),dice.getDie1(),dice.getDie2(),dice.getSum(),p.getCurrentPosition(),p.getAccount().getBalance());
    }

    public void displayTakingTurn(Player p){
        System.out.printf(Game.translation.getTakingTurnString()+ "\n",p.getName(), "Player num: " + p.getNum());
    }

    public void displayTurn(Player p){
        System.out.printf(Game.translation.getDisplayTurnString()+ "\n", p.getName(),p.getTurn());
    }

    public int[] getNearbyFields(Player player){
        int[] nearbyFields = new int[2];
        int position = player.getCurrentPosition();
        nearbyFields[0]=position-1;
        nearbyFields[1]=position+1;
        return nearbyFields;
    }
}








