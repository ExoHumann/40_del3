package spil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Player player = new Player();
        Player computer = new Player();

        player.setPlayerPoint(0);
        computer.setPlayerPoint(0);

        //Setting the players name
        System.out.println("Set your name");
        String pName = in.nextLine();
        player.setPlayerName(pName);
        pName = player.getPlayerName();
        //setting the computers name
        System.out.println("Set computers name");
        String cName = in.nextLine();
        computer.setPlayerName(cName);
        cName = computer.getPlayerName();

        System.out.println(pName + " Vs " + cName);

        int pPoint = player.getPlayerPoint();
        int cPoint = computer.getPlayerPoint();

        System.out.println(cName + " Has " + cPoint + " Points" );
        System.out.println(pName + " Has " + pPoint + " Points" );


        //The logic of the game if a player or computer reaches 40 the game stops and a winner is found
        while(cPoint < 40 && pPoint < 40) {
            int playeRroll1 = Dice.roll();
            int playeRroll2 = Dice.roll();
            int computeRroll1 = Dice.roll();
            int computeRroll2 = Dice.roll();

            int playerSum = playeRroll1 + playeRroll2;
            System.out.println(pName + " sum \t\t\t\t" +playerSum);
            pPoint = pPoint + playerSum;
            computer.setPlayerPoint(pPoint);
            System.out.println(pName + " combined points: \t" + pPoint);

            int computerSum = computeRroll1 + computeRroll2;
            System.out.println(cName + " sum: \t\t\t\t" + computerSum);
            cPoint = cPoint + computerSum;
            computer.setPlayerPoint(cPoint);
            System.out.println(cName + " combined points: \t" + cPoint);

        }

        System.out.println(cName + " Has " + cPoint + " Points" );
        System.out.println(pName + " Has " + pPoint + " Points" );

        //looking for who won the game. If 2 of them reached over 40 we look at who had most points.
        //If the game is tied the player wins
        if (pPoint < cPoint) {
            System.out.println(cName + " has won");
        } else {
            System.out.println(pName + " has won");
        }


/*
        int die1 = Dice.roll();
        int die2 = Dice.roll();
        int sum = die1 + die2;
        System.out.println(sum);


        for (int i = 0; i < 10; i++) {
            die1 = Dice.roll();
            die2 = Dice.roll();
            sum = die1 + die2;
            System.out.println("Roll:" + (i+1) + "  " + die1 + "+" + die2 + "=" + sum);

        }

 */


    }
}
