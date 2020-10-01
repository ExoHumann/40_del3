package spil;

import gui_fields.GUI_Field;
import gui_main.GUI;

public class Game {
    private final Player player;
    private final Player computer;
    private final int gamesAmount;
    private final Dice cDice;
    private final Dice pDice;
    final GUI gameGUI;
    private GUI_Field[] fields;

    public Game(GUI gameGUI, Player player, Player computer, int games, Dice cDice, Dice pDice) {
        this.player = player;
        this.computer = computer;
        this.cDice = cDice;
        this.pDice = pDice;
        gamesAmount = games;
        this.gameGUI = gameGUI;
        this.fields = gameGUI.getFields();


        play();
        displayWins(this.computer.getWin(), this.player.getWin());
    }

    public void displayWins(int computerWins, int playerWins) {
        System.out.println(player.getName() + " Has Won " + computerWins + " Games");
        System.out.println(computer.getName() + " Has Won " + playerWins + " Games");
        System.out.println("Tied games are " + player.getTie());
    }


    private void play() {
 /*public void movePlayer(Player player, Dice dice){
        int prePos = player.getCurrentPosition();
        player.move(dice.roll());
        player.setBalance(player.getScore());
        player.setScore(player.getScore() + dice.getSum());

        int pos = player.getCurrentPosition();
        if (fields[prePos].hasCar(player)){
            gameGUI.showMessage("Roll The Dice: " + player.getName() + "'s Turn");
            gameGUI.setDice(dice.getDice1(), dice.getDice2());
            fields[prePos].removeAllCars();
            fields[pos].setCar(player,true);

            if (dice.getEns()) {
                if (dice.getDice1() == 1) {
                    player.setBalance(0);
                    player.setCurrentPosition(0);
                    fields[prePos].hasCar(player);
                    fields[prePos].removeAllCars();
                    fields[0].setCar(player,true);
                }
            }
        }
   }*/
        for (int i = 0; i < gamesAmount; i++) {


            while (player.getScore() < 40 && computer.getScore() < 40) {

                movePlayer(player, pDice);
                movePlayer(computer, cDice);
                diceInfo(player, pDice);

                if (pDice.getEns()) {
                    if (pDice.getDice1() == 1) {
                        moveToStart(player);
                    }
                    /*if (pDice.getDice1() == 6){
                        movePlayer(player, pDice);
                        diceInfo(player, pDice);
                        if (pDice.getEns()) {
                            if (pDice.getDice1() == 6){
                                moveToStart(player);
                                diceInfo(player, pDice);
                            }
                        }*/

                    System.out.println("Extra Turn");
                    movePlayer(player, pDice);
                    diceInfo(player, pDice);
                }

                if (pDice.getEns()) {
                    if (pDice.getDice1() == 1) {
                        moveToStart(computer);
                    }
                    System.out.println("Extra Turn");
                    movePlayer(computer, cDice);
                    diceInfo(computer, cDice);
                }

            }

            if (player.getScore() > computer.getScore()) {
                computer.setWin();
            } else if (computer.getScore() > player.getScore()) {
                player.setWin();
            } else if (player.getScore() == computer.getScore()) {
                player.setTie();
                computer.setTie();
            }

            moveToStart(player);
            moveToStart(computer);
        }
    }

    private void diceInfo(Player player, Dice dice) {
        System.out.println(player.getName() + " " + dice.getDice1() + "+" + dice.getDice2() + "=" + dice.getSum() + " Position = " + player.getCurrentPosition() + " Score: " + player.getScore());
    }

    private void movePlayer(Player player, Dice dice) {
        int prePos = player.getCurrentPosition();
        player.setBalance(prePos);
        gameGUI.showMessage("Roll The Dice: " + player.getName() + "'s Turn");
        player.move(dice.roll());
        player.setScore(player.getScore() + dice.getSum());

        int pos = player.getCurrentPosition();
        if (fields[prePos].hasCar(player)) {
            gameGUI.setDice(dice.getDice1(), dice.getDice2());
            fields[prePos].removeAllCars();
            fields[pos].setCar(player, true);
            player.setBalance(pos);
        }
    }

    private void moveToStart(Player player) {
        int prePos = player.getCurrentPosition();
        if (fields[prePos].hasCar(player)) {
            fields[prePos].removeAllCars();
            fields[0].setCar(player, true);
            player.setBalance(0);
            player.setCurrentPosition(0);
            player.setScore(0);
        }
    }
}
