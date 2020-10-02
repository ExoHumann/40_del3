package spil;

import gui_fields.GUI_Field;
import gui_main.GUI;

public class Game {
    private final Player player1;
    private final Player player2;
    private final int gamesAmount;
    private final Dice cDice;
    private final Dice pDice;
    static GUI gameGUI;
    private final GUI_Field[] fields;

    public Game(GUI gameGUI, Player player1, Player player2, int games, Dice cDice, Dice pDice){
        this.player1 = player1;
        this.player2 = player2;
        this.cDice = cDice;
        this.pDice = pDice;
        gamesAmount = games;
        Game.gameGUI = gameGUI;
        this.fields = gameGUI.getFields();


        play();
        displayWins(this.player1.getWin(), this.player2.getWin());
    }

    private void displayWins(int player1Wins, int player2Wins) {
        System.out.println(player1.getName() + " Has Won " + player1Wins + " Games");
        System.out.println(player2.getName() + " Has Won " + player2Wins + " Games");
        System.out.println("Tied games are " + player1.getTie());
    }
    private void diceInfo(Player player, Dice dice) {
        System.out.println(player.getName() + " " + dice.getDice1() + "+" + dice.getDice2() + "=" + dice.getSum() + " Position = " + player.getCurrentPosition() + " Score: " + player.getScore());
    }

    private void play() {

        while (player1.getScore() < 40 && player2.getScore() < 40) {

            movesPlayer(player1, pDice);
            diceInfo(player1, pDice);
            movesPlayer(player2, cDice);
            diceInfo(player2, cDice);

            if (pDice.getEquals()) {
                if (pDice.getDice1() == 1) {
                    movesToStart(player1);
                } else if (pDice.getDice1() == 6) {
                    movesPlayer(player1, pDice);
                    diceInfo(player1, pDice);
                    if (pDice.getEquals()) {
                        if (pDice.getDice1() == 6) {
                            player1.setScore(40);
                            diceInfo(player1, pDice);
                        }
                    }
                }
            }
            if (cDice.getEquals()) {
                if (cDice.getDice1() == 1) {
                    movesToStart(player2);
                } else if (cDice.getDice1() == 6) {
                    movesPlayer(player2, cDice);
                    diceInfo(player2, cDice);
                    if (cDice.getEquals()) {
                        if (cDice.getDice1() == 6) {
                            player2.setScore(40);
                            diceInfo(player2, cDice);
                        }
                    }
                }
            }
        }
        if (player1.getScore() > player2.getScore()) {
            player2.setWin();
        } else if (player2.getScore() > player2.getScore()) {
            player1.setWin();
        } else if (player1.getScore() == player2.getScore()) {
            player1.setTie();
            player2.setTie();
        }

        movesToStart(player1);
        movesToStart(player2);
    }

    public void movesPlayer(Player player, Dice dice) {
        int prePos = player.getCurrentPosition();
        player.setBalance(prePos);
        gameGUI.showMessage("Roll The Dice: " + player.getName() + "'s Turn");
        player.move(dice.roll());
        player.setScore(player.getScore() + dice.getSum());

        int pos = player.getCurrentPosition();
        if (fields[prePos].hasCar(player)) {
            gameGUI.setDice(dice.getDice1(), dice.getDice2());
            fields[prePos].setCar(player, false);
            fields[pos].setCar(player, true);
            player.setBalance(pos);
        }
    }

    private void movesToStart(Player player) {
        int prePos = player.getCurrentPosition();
        if (fields[prePos].hasCar(player)) {
            fields[prePos].setCar(player, false);
            fields[0].setCar(player, true);
            player.setBalance(0);
            player.setCurrentPosition(0);
            player.setScore(0);
        }
    }

}