package spil;

public class Game {
    private final Player player;
    private final Player computer;
    private final int gamesAmount;


    public Game(Player player, Player computer, int games){
        this.player = player;
        this.computer = computer;
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
                int playerRoll1 = Dice.roll();
                int playerRoll2 = Dice.roll();
                int computerRoll1 = Dice.roll();
                int computerRoll2 = Dice.roll();

                int playerSum = playerRoll1 + playerRoll2;
                int computerSum = computerRoll1 + computerRoll2;

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
