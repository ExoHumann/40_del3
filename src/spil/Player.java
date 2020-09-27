package spil;

public class Player {

    private String name;
    private int score;
    private int win = 0;
    private int tie = 0;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void setWin(){ this.win++; }
    public int getWin(){ return this.win; }

    public void setTie(){ this.tie++; }
    public int getTie(){ return this.tie; }

    public void setName(String name){ this.name = name; }
    public String getName(){ return name; }

    public void setScore(int score){ this.score = score; }
    public int getScore(){ return score; }


}
