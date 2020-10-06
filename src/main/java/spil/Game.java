package spil;

public class Game {
    private final Player player1;
    private final Player player2;
    private final int gamesAmount;
    private final Dice cDice;
    private final Dice pDice;

    public Game(Player player1, Player player2, int games, Dice cDice, Dice pDice){
        this.player1 = player1;
        this.player2 = player2;
        this.cDice = cDice;
        this.pDice = pDice;
        gamesAmount = games;


        play();
        displayWins(this.player1.getWin(), this.player2.getWin());
    }

    private void displayWins(int player1Wins, int player2Wins) {
        System.out.println(player1.getName() + " Has Won " + player1Wins + " Games");
        System.out.println(player2.getName() + " Has Won " + player2Wins + " Games");
        System.out.println("Tied games are " + player1.getTie());
    }
    private void diceInfo(Player player, Dice dice) {
        System.out.println(player.getName() + " " + dice.getDice1() + "+" + dice.getDice2() + "=" + dice.getSum() + " Position = " + player.getCurrentPosition() + " Balance: " + player.getBalance());
    }

    private void play() {

        for (int i = 0; i < gamesAmount; i++) {

        while (player1.getBalance() < 40 && player2.getBalance() < 40) {

            GameGUI.movesPlayer(player1, pDice);
            diceInfo(player1, pDice);
            GameGUI.movesPlayer(player2, cDice);
            diceInfo(player2, cDice);

        }

        if (player1.getBalance() > player2.getBalance()) {
            player1.setWin();
        } else if (player2.getBalance() > player1.getBalance()) {
            player2.setWin();
        } else if (player1.getBalance() == player2.getBalance()) {
            player1.setTie();
            player2.setTie();
        }

        GameGUI.movesToStart(player1);
        GameGUI.movesToStart(player2);
        }
    }
}