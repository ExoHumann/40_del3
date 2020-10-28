package Model;


import Model.Playerlist.Account;
import Model.Playerlist.Player;

import java.awt.*;

public class PlayerList {

    Player[] players;
    Account[] accounts;

    private String[] names = {"Peter", "Marcus", "Oliver", "Phill"};
    private Color[] colors = {Color.CYAN, Color.GREEN, Color.WHITE, Color.BLUE, Color.orange, Color.RED, Color.WHITE };

    /**
     * Makes a new player and account for that player and stores it in the playerlist
     * @param playerAmount Specifies how many accounts and players you want to make
     */
    public PlayerList(int playerAmount){
        players = new Player[playerAmount];
        accounts = new Account[playerAmount];
        for (int i = 0; i < playerAmount; i++) {
            players[i] = new Player(null,getColor(i));
            accounts[i] = new Account(0);
        }
    }

    //Getters and setters
    public Color[] getColors() { return colors; }
    public Color getColor(int id) { return colors[id];}

    public Player[] getPlayersList() { return players; }
    public Player getPlayerList(int id) { return players[id]; }

    public Account[] getAccounts(){ return accounts; }
    public Account getAccount(int id){ return accounts[id];}

    private int getSize() { return players.length; }

}
