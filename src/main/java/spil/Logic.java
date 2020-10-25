package spil;

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class Logic {

    private int prePos;
    private int pos;

    public Logic(int prePos, int pos){
        this.prePos = prePos;
        this.pos = pos;
    }

    public void diceInfo(PlayerList pl, Dice dice, int PNum) {
        System.out.println("Name: " + pl.getPlayerList(PNum).getName() +
                " Dice Results " + dice.getDie1() + "+" + dice.getDie2() + "=" + dice.getSum() +
                " Position = " + pl.getPlayerList(PNum).getCurrentPosition() +
                " Balance: = " + pl.getAccount(PNum).getBalance() );

    }

    //Updates the roll and position of the dice
    public void movePlayer(PlayerList pl, FieldList fl, Dice dice, int playerTurn) {
        Player player = pl.getPlayerList(playerTurn);
        Account account = pl.getAccount(playerTurn);

        prePos = player.getCurrentPosition();
        player.move(dice.roll());
        pos = player.getCurrentPosition();

        switch (pos) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                account.addBalance(fl.getField(pos).getPrice());
                break;
            default:
                break;
        }
        System.out.println("your position is " + pos + " your balance is now " + pl.getAccount(playerTurn).getBalance());
    }

/*
    public void findWinner(PlayerList pl){
        Player[] player = pl.getPlayersList();
        Account[] account = pl.getAccounts();

        for (int i = 0; i < p.length; i++) {

            if (account[i].getBalance() >= 2000){

            }
        }

    }
*/

    public int getPrePos() { return prePos; }
    public int getPos() { return pos; }
    public void setPos(int pos) { this.pos = pos; }
}



