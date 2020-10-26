package spil;

import java.awt.*;

public class PlayerList {

    Player[] players;
    Account[] accounts;
    private int PNum;

    private String[] names = {"Peter", "Marcus", "Oliver", "Phill"};
    private Color[] colors = {Color.CYAN, Color.GREEN, Color.WHITE, Color.BLUE, Color.orange, Color.RED };

    /**
     * Makes a new player and account for that player and stores it in the playerlist
     * @param playerAmount Specifies how many accounts and players you want to make
     */
    public PlayerList(int playerAmount){
        this.PNum = playerAmount;
        players = new Player[playerAmount];
        accounts = new Account[playerAmount];
        for (int i = 0; i < playerAmount; i++) {
            players[i] = new Player(null,colors[i]);
            accounts[i] = new Account(1000);
        }
    }

    //Getters and setters
    public int getPNum() { return PNum; }

    public Color[] getColors() { return colors; }
    public Color getColor(int id) { return colors[id];}

    public Player[] getPlayersList() { return players; }
    public Player getPlayerList(int id) { return players[id]; }

    public Account[] getAccounts(){ return accounts; }
    public Account getAccount(int id){ return accounts[id];}

    private int getSize() { return players.length; }

}
