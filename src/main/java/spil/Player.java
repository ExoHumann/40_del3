package spil;

import java.awt.*;

public class Player {

    private String name;
    private Color color;
    private int currentPosition;

    public Player(String name, Color color){
        this.name = name;
        this.color = color;
    }


    public int getCurrentPosition() {
        return currentPosition;
    }

    public  void setCurrentPosition(int position){
        this.currentPosition = position;
    }

    public void move(int position){
        this.currentPosition = (currentPosition + position) % 40;
    }

    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String toString(){
        return name;
    }

}