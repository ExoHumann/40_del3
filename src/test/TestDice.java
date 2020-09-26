package test;

import java.util.Random;

public class TestDice {

    //Max and min i defined
    private static final int Max_dots = 6;
    private static final int min = 1;

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
