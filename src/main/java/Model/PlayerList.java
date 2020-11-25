package Model;


import Model.Playerlist.Account;
import Model.Playerlist.Player;

import java.awt.*;

public class PlayerList {

    Player[] players;
    Account[] accounts;
    Player currentPlayer;

    int currentPlayerID;

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
            accounts[i] = new Account(0);
            players[i] = new Player(null,colors[i], accounts[i]);
            players[i].setAccount(accounts[i]);
            players[i].setNum(i);
        }
    }

    //Getters and setters
    public Color getColor(int id) { return colors[id% colors.length];}

    public int getPlayerAmount() { return players.length; }
    public Player getPlayerList(int id) { return players[id]; }

    public Account[] getAccounts(){ return accounts; }
    public Account getAccount(int id){ return accounts[id];}


    public void setNames(String[] names) {
        this.names = names;
    }

    public Player setCurrentPlayer(int index){
        return currentPlayer = players[index];
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public Player getNextPlayer(){
        currentPlayerID = (currentPlayerID + 1) % players.length;
        currentPlayer = players[currentPlayerID];
        return currentPlayer;
    }
}
