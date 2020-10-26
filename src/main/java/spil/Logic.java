package spil;

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

    public void displayTakingTurn(PlayerList pl, int PNum){
        System.out.println("The player " + pl.getPlayerList(PNum).getName() + " is now taking his turn turn");
    }

    public void displayTurn(PlayerList pl, int PNum){
        System.out.println(pl.getPlayerList(PNum).getName() + " has taken: " + pl.getPlayerList(PNum).getTurn() + " Turn(s)");
    }

    //Updates the roll and position of the dice
    public void movePlayer(PlayerList pl, FieldList fl, Dice dice, int playerTurn) {
        Player player = pl.getPlayerList(playerTurn);
        Account account = pl.getAccount(playerTurn);

        prePos = player.getCurrentPosition();
        player.move(dice.roll(), fl);
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
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                account.addBalance(fl.getField(pos).getPrice());
                break;
            default:
                break;
        }
        System.out.println(pl.getPlayerList(playerTurn).getName() + " landed on the field nr " + pos + " " + fl.getField(pos).getTitle() + " and you will receive/pay the price of this field " + fl.getField(pos).getPrice());
    }


    public boolean winCondition(PlayerList pl, int PNum) {
        boolean winCondition;
        winCondition = pl.getAccount(PNum).getBalance() <= 3000;
        return winCondition;
    }





    public int getPrePos() { return prePos; }
    public int getPos() { return pos; }
    public void setPos(int pos) { this.pos = pos; }
}



