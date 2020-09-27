package spil;

public class Player {

    private String name;
    private int Score;
    private int win = 0;
    private int tie = 0;

    public Player(String name, int Score) {
        this.name = name;
        this.Score = Score;
    }

    public void setWin(){ this.win++; }
    public int getWin(){ return this.win; }

    public void setTie(){ this.tie++; }
    public int getTie(){ return this.tie; }

    public void setName(String name){ this.name = name; }
    public String getName(){ return name; }

    public void setScore(int point){ Score = point; }
    public int getScore(){ return Score; }


}
