package spil;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;

public class Player extends GUI_Player {

    private String name;
    private int score;
    private int win = 0;
    private int tie = 0;
    private int currentPosition;

    public Player(String playerName, int score, GUI_Car car) {
        super(playerName, score, car);
        this.name = playerName;
        this.currentPosition = 0;
    }

    public void setWin(){ this.win++; }
    public int getWin(){ return this.win; }

    public void setTie(){ this.tie++; }
    public int getTie(){ return this.tie; }

    public void setScore(int score){ this.score = score; }
    public int getScore(){ return score; }


    public int getCurrentPosition() {
        return currentPosition;
    }

    public  void setCurrentPosition(int position){
        this.currentPosition = position;
    }

    public void move(int position){
        this.currentPosition = (currentPosition + position) % 40;
    }
}
