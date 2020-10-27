package spil;

import testny.Player;

public class Logic {

    private int prePos;
    private int pos;

    /**
     * Keeps trac of where the player was before the roll - and after the roll of dice
     * @param prePos Previous position
     * @param pos Current position he heading towards
     */
    public Logic(int prePos, int pos){
        this.prePos = prePos;
        this.pos = pos;
    }

    /**
     * Updates the roll and position of the dice
     * Moves the player outside of the GUI.
     * Manages the balance of the player
     * @param pl Playlist used to access players account and position
     * @param fl FieldList used to access the price of the fields
     * @param dice Dice used to update the roll and move the player
     * @param playerTurn Which player is taking a turn
     */
    public void movePlayer(PlayerList pl, FieldList fl, Dice dice, int playerTurn) {
        Player player = pl.getPlayerList(playerTurn);
        Account account = pl.getAccount(playerTurn);

        prePos = player.getCurrentPosition();
        player.move(dice.roll(), fl);
        pos = player.getCurrentPosition();

        switch (pos) {
            case 0: case 1: case 3: case 5: case 8: case 11:
                account.deposit(fl.getField(pos).getPrice());
                break;
            case 2: case 4: case 7: case 9: case 10:
                account.withdraw(fl.getField(pos).getPrice());
                break;
            case 6:
            default:
                break;
        }
        System.out.println(pl.getPlayerList(playerTurn).getName() + " landed on the field nr " + pos + " " + fl.getField(pos).getTitle() + " and you will receive/pay the price of this field " + fl.getField(pos).getPrice());
    }

    /**
     * Describes the win condition of the game if a player has 3000 balance
     * @param pl player list used to access accounts and check all counts
     * @return Returns if the condition is met or no
     */
    public boolean winCondition(PlayerList pl) {
        boolean winCondition = false;
        for (int i = 0; i <pl.getAccounts().length ; i++) {
            if (pl.getAccount(i).getBalance() >= 3000) winCondition = true;
        }
        return winCondition;
    }

    public void findWinner(PlayerList pl, int playerTurn){
        System.out.println(pl.getPlayerList(playerTurn).getName() + " Has won with the balance of" + pl.getAccount(playerTurn).getBalance());
    }


    public void diceInfo(PlayerList pl, Dice dice, int PNum) {
        System.out.println("Name: " + pl.getPlayerList(PNum).getName() +
                " Dice Results " + dice.getDie1() + "+" + dice.getDie2() + "=" + dice.getSum() +
                " Position = " + pl.getPlayerList(PNum).getCurrentPosition() +
                " Balance: = " + pl.getAccount(PNum).getBalance() );
    }

    public void displayTakingTurn(PlayerList pl, int PNum){
        System.out.println("The player " + pl.getPlayerList(PNum).getName() + " is now taking his turn turn");
    }

    public void displayTurn(PlayerList pl, int PNum){
        System.out.println(pl.getPlayerList(PNum).getName() + " has taken: " + pl.getPlayerList(PNum).getTurn() + " Turn(s)");
    }

    //Getters and setters
    public int getPrePos() { return prePos; }
    public int getPos() { return pos; }
    public void setPos(int pos) { this.pos = pos; }
}







