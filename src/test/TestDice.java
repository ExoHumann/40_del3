package test;
import java.util.Random;
import java.util.Scanner;

public class TestDice {

    public static void main(String[] args) {

        System.out.println("Enter amount of test rolls:");

        // User specifies amount of die rolls
        Scanner input = new Scanner(System.in);
        int rollCount = input.nextInt();

        // Array for roll results for each die value
        int[] diceCount ={0,0,0,0,0,0};

        Random r = new Random();

        // Loop x times
        for (int i = 0; i < rollCount; i++) {

            // Generate die value
            int die = r.nextInt(6)+1;

            // Increment die index
            diceCount[die-1]++;
        }

        // Display results
        System.out.println("Distribution of rolls:");
        for (int i=0;i<6;i++){
            System.out.println(i+1 + ": " + diceCount[i]);
        }
    }
}
