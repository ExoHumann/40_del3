package spil;

import java.awt.*;

public class Player {

    private String name;
    private Color color;
    private int currentPosition;
    private int turn;

    public Player(String name, Color color){
        this.name = name;
        this.color = color;
        int turn = 0;
    }


    public int getCurrentPosition() {
        return currentPosition;
    }

    public  void setCurrentPosition(int position){
        this.currentPosition = position;
    }

    public void move(int position, FieldList fl){
        int fieldLength = fl.getSize();
        this.currentPosition = (currentPosition + position) % fieldLength;
    }


    public void incrementTurn(){ turn++; }
    public int getTurn(){ return turn;}
    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String toString(){
        return name;
    }

}