package test;

import spil.Dice;

import java.util.Random;

public class TestDice extends Dice {

    //Max and min i defined
    private static final int Max_dots = 6;
    private static final int min = 1;

    public TestDice(int dice1, int dice2) {
        super(dice1, dice2);
    }




    public static void main(String[] args) {


        //"Random" class is implemented
        Random die = new Random();

        //Random number is generated
        // int die1 = die.nextInt(Max_dots)+min;


        //Loop 1000 times
        for (int i = 0; i < 1000; i++) {

            //Random number is generated
            int die1 = die.nextInt(Max_dots) + min;

            System.out.println(die1);

        }
    }
}
