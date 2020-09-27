package spil;

public class Game {
    private final Player player;
    private final Player computer;
    private final int gamesAmount;
    private final Dice cDice;
    private final Dice pDice;


    public Game(Player player, Player computer, int games, Dice cDice, Dice pDice){
        this.player = player;
        this.computer = computer;
        this.cDice = cDice;
        this.pDice = pDice;
        gamesAmount = games;


        play();
        displayWins(this.computer.getWin(), this.player.getWin());
        }

    public void displayWins(int computerWins, int playerWins) {
        System.out.println(player.getName() + " has won " + computerWins + " Games");
        System.out.println(computer.getName() + " has won " + playerWins + " Games");
        System.out.println("Tied games are " + player.getTie());
    }


    private void play() {
        int pScore = player.getScore();
        int cScore = computer.getScore();


        for (int i = 0; i < gamesAmount; i++) {

            while (cScore < 40 && pScore < 40) {

                pDice.roll();
                int playerSum = pDice.getSum();
                cDice.roll();
                int computerSum = cDice.getSum();

                pScore = pScore + playerSum;
                computer.setScore(pScore);

                cScore = cScore + computerSum;
                computer.setScore(cScore);
            }

            if (pScore < cScore) {
                computer.setWin();
            } else if (cScore < pScore) {
                player.setWin();
            } else if (pScore == cScore) {
                player.setTie();
                computer.setTie();
            }

            cScore = 0;
            pScore = 0;
        }


    }
}
