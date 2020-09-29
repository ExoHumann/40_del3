package test;
import java.util.Random;
import java.util.Scanner;

public class TestDice {

    public static void main(String[] args) {

        int rollCount;
        int die;

        System.out.println("Inddtast antal terning-kast");

        Scanner input = new Scanner(System.in);
        rollCount = input.nextInt();




        int[] diceCount ={0,0,0,0,0,0};

        Random r = new Random();

        //Loop x times
        for (int i = 0; i < rollCount; i++) {

            die = r.nextInt(6)+1;
            diceCount[die-1]++;

        }
        System.out.println("Fordeling at kast:");
        for (int i=0;i<6;i++){

            System.out.println(i+1 + ": " + diceCount[i]);
        }
    }
}
