package spil;

import java.util.Random;

public class Dice {

    private static int faceValue;
    static int max = 6;
    private static int sum;

    public Dice(int faceValue, int max) {
        Dice.faceValue = faceValue;
        Dice.max = max;
    }

    public static int roll(){
        Random r = new Random();
        faceValue = r.nextInt(max)+1;
        return faceValue;
    }

   public String toString(){
       return Integer.toString(faceValue);
   }

}
