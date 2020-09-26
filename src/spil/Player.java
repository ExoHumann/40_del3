package spil;

public class Player extends Dice {

    private static String playerName;
    private static int playerPoint;
    private int win = 0;
    private int tie = 0;

    public Player(int faceValue, int maxNumber) {
        super(faceValue, maxNumber);
    }

    public void setWin(){
        this.win++;
    }

    public int getWin(){
        return this.win;
    }
    public void setTie(){
        this.tie++;
    }

    public int getTie(){
        return this.tie;
    }

    public void setPlayerName(String name){
        playerName = name;
    }
    public String getPlayerName(){
        return playerName;
    }
    public void setPlayerPoint(int point){
        playerPoint = point;
    }
    public int getPlayerPoint(){
        return playerPoint;
    }


}
