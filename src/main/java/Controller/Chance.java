package Controller;

import Model.FieldList;
import Model.PlayerList;
import Model.Playerlist.Account;
import Model.Playerlist.Player;

//import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;

public class Chance {


    public Chance() {
    }
boolean init[]=new boolean [20];
    Random ra=new Random();
    int chance;
    private static final int deckSize=20;

    public void drawCard(){
        int amountOfCards = 20;
        Random r = new Random(amountOfCards);
        chance = r.nextInt();



//void Shufle(){
//int[] Bunke=new int[20];
//for (int i=0; i < Bunke.length  ; i++) {
//    Bunke[i]=getNewKort();
}
//    System.out.println(Arrays.toString(Bunke));}

int getNewKort() {
    int i=ra.nextInt(20);
    while (init[i])
        i=ra.nextInt(20);
    init[i]=true;
    return i;
        }



    public static void main(String[] args) {
        ArrayList<Integer> deck=new ArrayList<>();
        for (int i = 0; i < deckSize; i++) {
            deck.add(i);
        }
        Collections.shuffle(deck);
        System.out.println(deck);

    }
    public void chance(PlayerList pl, FieldList fl, int playerTurn, int playerChoice){
        Player player = pl.getPlayerList(playerTurn);
        Account account = pl.getAccount(playerTurn);

        drawCard();

        switch (chance) {
            case 0:
            case 1:
                player.setCurrentPosition(0);
                account.deposit(2);
            case 2:
                player.move(playerChoice, fl);
            case 3:
            case 4:
                if (playerChoice == 1){
                    player.move(1,fl);
                } else if (playerChoice == 2) {
                    drawCard();
                }
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:


        }
    }




}
