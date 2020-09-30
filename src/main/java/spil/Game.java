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

    public Game(GUI gameGUI, Player player, Player computer, int games, Dice cDice, Dice pDice){
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

        for (int i = 0; i < gamesAmount; i++) {

            while (computer.getScore() < 40 && player.getScore() < 40) {

                movePlayer(player, pDice);
                movePlayer(computer, cDice);



                /*if (fields[0].hasCar(player)){
                    gameGUI.showMessage("Moving the car");
                    fields[0].removeAllCars();
                    fields[1].setCar(player, true);
                }*/
/*''''''''''
                player.setScore(player.getScore() + pDice.roll());
                computer.setScore(computer.getScore() + cDice.roll());

                System.out.println(player.getName() + " " + pDice.getDice1() + "+" + pDice.getDice2() + "=" + pDice.getSum() + " Score= " + player.getScore());
                System.out.println(computer.getName() + " " + cDice.getDice1() + "+" + cDice.getDice2() + "=" + cDice.getSum() + " Score= " + computer.getScore());
*/

                if (pDice.getEns()) {
                    if (pDice.getDice1() == 1) {
                        player.setScore(0);
                    }
                    player.setScore(player.getScore() + pDice.roll());
                    System.out.println("Extra turn for: " + player.getName() + " " + pDice.getSum() + " Score " + player.getScore());
                }
                if (cDice.getEns()) {
                    if (cDice.getDice1() == 1) {
                        computer.setScore(0);
                    }
                    computer.setScore(computer.getScore() + cDice.roll());
                    System.out.println("Extra turn for: " + computer.getName() + " " + cDice.getSum() + " Score " + computer.getScore());
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

            player.setScore(0);
            computer.setScore(0);
        }
    }

    public void movePlayer(Player player, Dice dice){
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
                    player.setScore(0);
                    player.setCurrentPosition(0);
                    fields[prePos].hasCar(player);
                    fields[prePos].removeAllCars();
                    fields[0].setCar(player,true);
                }
                player.setScore(player.getScore() + dice.roll());
                System.out.println("Extra turn for: " + player.getName() + " " + dice.getSum() + " Score " + player.getScore());
            }
        }
    }
}