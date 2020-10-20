
package spil;

public class Game {

    FieldList fl = new FieldList();
    private Player[] players;
    private int games;
    private Dice dice;


    public Game(Player[] players, int games, Dice dice){
        this.players = players;
        this.games = games;
        this.dice = dice;


        play();
    }

    private void play() {

    }

    private void diceInfo(Player player, Dice dice) {
        System.out.println(player.getName() + " " + dice.getDie1() + "+" + dice.getDie2() + "=" + dice.getSum() + " Position = " + player.getCurrentPosition() + " Balance: " );
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

}