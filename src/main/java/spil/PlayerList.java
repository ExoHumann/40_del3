package spil;

import java.awt.*;

public class PlayerList {

    Player[] players;
    private int PNum;
    
    private Color[] colors = {Color.CYAN, Color.PINK, Color.WHITE, Color.BLUE};
    public PlayerList(int id){
        this.PNum = id;
        players = new Player[id];
        for (int i = 0; i < id; i++) {
            players[i] = new Player(null,colors[i]);
        }
    }

    public int getPNum() { return PNum; }


    public Color[] getColors() { return colors; }
    public Color getColor(int id) { return colors[getPNum()];}

    public Player[] getPlayersList() { return players; }
    public Player getPlayerList(int id) { return players[getPNum()]; }

    private int getSize() { return players.length; }

}
