package Model.Playerlist;

import Model.FieldList;

import java.awt.*;

public class Player {

    private int pNum;
    private String name;
    private Color color;
    private Account account;
    private int previousPosition;
    private int currentPosition;
    private int turn;
    boolean isInJail;
    boolean getOutOfJailCard;
    public boolean buyNextPossibleField;

    /**
     * Constructor for the player takes a name and color
     * @param name Players name
     * @param color Players color used for example to set his car color
     * @param account Player account
     */
    public Player(String name, Color color, Account account){
        this.name = name;
        this.color = color;
        this.account = account;
        this.turn = 0;
    }

    /**
     * Updates the position of the player and makes sure he can go all the way around with modulus
     * @param position The position is the amount of fields the player is going to move
     * @param fl field list is used to get the amount of fields on the board
     */
    public void move(int position, FieldList fl){
        int fieldLength = fl.getSize();
        setPreviousPosition();
        this.currentPosition = (currentPosition + position) % fieldLength;
    }

    public int getPreviousPosition(){
        return previousPosition;
    }
    public void setPreviousPosition(){
        this.previousPosition = currentPosition;
    }


    public int getCurrentPosition() {
        return currentPosition;
    }
    public  void setCurrentPosition(int position){
        setPreviousPosition();
        this.currentPosition = position;
    }

    public void incrementTurn(){
        turn++; }
    public int getTurn(){
        return turn;}

    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public void setInJail(boolean isInJail){ this.isInJail = isInJail; }
    public boolean isInJail(){ return isInJail;}

    public void setGetOutOfJailCard(boolean getOutOfJailCard){ this.getOutOfJailCard = getOutOfJailCard; }
    public boolean isGetOutOfJailCard() { return getOutOfJailCard; }

    public String toString(){
        return name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getNum() { return pNum; }

    public void setNum(int pNum) { this.pNum = pNum; }

}