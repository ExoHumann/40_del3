package spil;

import java.util.Random;

public class Dice {

    private static int diceAmount;
    private static int faceValue = 0;


    public Dice(int faceValue, int diceAmount) {
        Dice.faceValue = faceValue;
        Dice.diceAmount = diceAmount;
    }


    public static int roll(){
        Random r = new Random();
        faceValue = r.nextInt(6)+1;
        return faceValue;
    }

    public String toString(){
        return Integer.toString(faceValue);
    }

    public int getFaceValue() { return faceValue; }



}

