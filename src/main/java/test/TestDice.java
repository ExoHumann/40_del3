package test;
import java.util.Scanner;
import spil.Dice;

public class TestDice {

    public static void main(String[] args) {

        //Dice object is created from the dice class
        Dice dice = new Dice(0,0);
        dice.roll();


        System.out.println("Enter amount of test rolls:");

        // User specifies amount of die rolls
        Scanner input = new Scanner(System.in);
        int rollCount = input.nextInt();

        // Array for roll results for each die value
        int[] diceCount ={0,0,0,0,0,0,0,0,0,0,0};

        // Loop x times
        for (int i = 0; i < rollCount; i++) {

            // Generate both dice values
            dice.roll();
            // Increment die index
            diceCount[dice.getSum()-2]++;
        }

        // Display results
        System.out.println("Distribution of rolls:");
        for (int i=0;i<11;i++){
            System.out.println(i+2 + ": " + diceCount[i]);

        }

    }

}
