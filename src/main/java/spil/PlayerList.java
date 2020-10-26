package spil;

import java.awt.*;

public class PlayerList {

    Player[] players;
    Account[] accounts;
    private int PNum;

    private String[] names = {"Peter", "Marcus", "Oliver", "Phill"};
    private Color[] colors = {Color.CYAN, Color.PINK, Color.WHITE, Color.BLUE};

    public PlayerList(int PNum){
        this.PNum = PNum;
        players = new Player[PNum];
        accounts = new Account[PNum];
        for (int i = 0; i < PNum; i++) {
            players[i] = new Player(null,colors[i]);
            accounts[i] = new Account(1000);
        }
    }

    public int getPNum() { return PNum; }

    public Color[] getColors() { return colors; }
    public Color getColor(int id) { return colors[id];}

    public Player[] getPlayersList() { return players; }
    public Player getPlayerList(int id) { return players[id]; }

    public Account[] getAccounts(){ return accounts; }
    public Account getAccount(int id){ return accounts[id];}

    private int getSize() { return players.length; }

}
