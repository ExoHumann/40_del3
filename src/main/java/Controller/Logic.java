package Controller;

import Model.Dice;
import Model.FieldList;
import Model.Fields.Field;
import Model.PlayerList;
import Model.Playerlist.*;
import Translation.Translator;

public class Logic {

    boolean landedOnChance;
    boolean drawAnother;
    public int prePos;
    public int pos;

    private BuyingController buyingController;
    private Translator tr;

    public Logic(Translator translator) {
        tr = translator;
        this.buyingController = new BuyingController();
    }

    /**
     * Updates the roll and position of the dice
     * Moves the player outside of the GUI.
     * Manages the balance of the player
     * @param pl Playlist used to access players account and position
     * @param fl FieldList used to access the price of the fields
     * @param moveAmount Dice used to update the roll and move the player
     * @param playerTurn Which player is taking a turn
     */
    public void movePlayer(PlayerList pl, FieldList fl, int moveAmount, int playerTurn) {
        Player player = pl.getPlayerList(playerTurn);
        Account account = pl.getAccount(playerTurn);

        prePos = player.getCurrentPosition();
        player.move(moveAmount, fl);
        pos = player.getCurrentPosition();

        //Player crossed start
        if (prePos > pos){
            account.deposit(2);
        }

        switch (pos) {
            case 0: case 6: case 12:
                break;

            case 3: case 9: case 15: case 21:
                landedOnChance = true;
                break;

            case 18:
                jailPlayer(player);
                player.setCurrentPosition(6);
                break;

            default:
                buyingController.buyField(pl,fl,playerTurn);
        }
        System.out.printf(tr.getLandedString(),
                player.getName(), pos, fl.getField(pos).getTitle(), fl.getField(pos).getPrice());
    }

    public int moveAmount(int moveToPos, FieldList fl){
        return (fl.getSize() + moveToPos - pos-1)%fl.getSize()+1;
    }

        /**
         * Describes the win condition of the game if a player has 0 balance
         * @param pl player list used to access accounts and check all accounts
         * @return Returns if the condition is met or no
         */
    public boolean winCondition(PlayerList pl) {
        boolean winCondition = false;
        for (int i = 0; i <pl.getAccounts().length ; i++) {
            if (pl.getAccount(i).getBalance() <= 0) winCondition = true;
        }
        return winCondition;
    }

    public void findWinner(PlayerList pl, int playerTurn){
        System.out.println(pl.getPlayerList(playerTurn).getName() + tr.getWonString() + pl.getAccount(playerTurn).getBalance());
    }


    public void diceInfo(PlayerList pl, Dice dice, int PNum) {
        System.out.printf(tr.getDiceInfo() +"\n",pl.getPlayerList(PNum).getName(),dice.getDie1(),dice.getDie2(),dice.getSum(),pl.getPlayerList(PNum).getCurrentPosition(),pl.getAccount(PNum).getBalance());
    }

    public void displayTakingTurn(PlayerList pl, int PNum){
        System.out.printf(tr.getTakingTurnString()+ "\n",pl.getPlayerList(PNum).getName(), "Player num: " + PNum);
    }

    public void displayTurn(PlayerList pl, int PNum){
        System.out.printf(tr.getDisplayTurnString()+ "\n", pl.getPlayerList(PNum).getName(),pl.getPlayerList(PNum).getTurn());
    }

    /**
     * Gets the 2 nearby fields of the player
     * @param player player
     * @return array of field id's
     */
    public int[] getNearbyFields(Player player){
        int[] nearbyFields = new int[2];
        int position = player.getCurrentPosition();
        nearbyFields[0]=position-1;
        nearbyFields[1]=position+1;
        return nearbyFields;
    }

    /**
     * Finds the player id, that has the highest balance.
     * @param list List of Players
     * @return id of the player with the highest balance
     */
    public int getPlayerHighestBalance(PlayerList list){
        Account highBalance;
        highBalance = list.getAccount(0);
        int id = 0;
        for (int i = 0; i < list.getAccounts().length; i++) {
            if (list.getAccounts()[i].getBalance()>highBalance.getBalance()){
                highBalance = list.getAccount(i);
                id=i;
            }
        }
        return id;
    }

    public void jailPlayer(Player player){
        player.setInJail(!player.getInJail());
    }

    public int getPrePos() { return prePos; }
    public int getPos() { return pos; }
    public void setPos(int pos) { this.pos = pos; }
}








