package spil;

import java.util.Random;

public class Dice {

    private static int faceValue;
    private static int maxNumber = 6;


    public Dice(int faceValue, int maxNumber) {
        this.faceValue = faceValue;
        this.maxNumber = maxNumber;
    }


    public static int roll(){
        Random r = new Random();
        faceValue = r.nextInt(maxNumber)+1;
        return faceValue;
    }

    public String toString(){
        return Integer.toString(faceValue);
    }

    public static int getFaceValue() { return faceValue; }

}

