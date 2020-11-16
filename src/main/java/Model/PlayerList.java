package Model;


import Model.Playerlist.Account;
import Model.Playerlist.Player;

import java.awt.*;
import java.util.Random;

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
            players[i] = new Player(null,colors[i]);
            accounts[i] = new Account(0);
        }
    }

    //Getters and setters
    public Color getColor(int id) { return colors[id% colors.length];}

    public int getPlayerAmount() { return players.length; }
    public Player getPlayerList(int id) { return players[id]; }

    public Account[] getAccounts(){ return accounts; }
    public Account getAccount(int id){ return accounts[id];}


}
