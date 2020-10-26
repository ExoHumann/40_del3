package spil;

import java.util.Random;

public class Dice {

    private int die1;
    private int die2;


    /**
     * Creates two random dice and use the method roll()
     * @param die1 value of the first dice
     * @param die2 value of the secend dice
     */
    public Dice(int die1, int die2) {
        this.die1 = die1;
        this.die2 = die2;
        roll();
    }


    /**
     * Chooses a random values between 1-6
     * @return Returns the sum of bot values
     */
    public int roll(){
        Random r = new Random();
        die1 = r.nextInt(6)+1;
        die2 = r.nextInt(6)+1;
        return getSum();
    }

    //Getters and setters
    boolean getEquals(){ return die1 == die2; }
    public void setDice (int dice1, int dice2) { this.die1 = dice1; this.die2 = dice2;}
    public int getDie1() { return die1; }
    public int getDie2() { return die2; }
    public int getSum() { return die1 + die2;}
    public String toString(){
        return Integer.toString(roll());
    }
}
