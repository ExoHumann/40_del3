package Controller;

import Model.PlayerList;
import Model.Playerlist.Player;
import View.GameGUI;
import org.junit.jupiter.api.Test;

class GameTest {


    @Test
    public void play() throws InterruptedException {
        Game game = new Game();
        game.play();

    }


    @Test
    void takeJailTurn() {
        takeJailTurn();
    }


    @Test
    void rollNMove() {
        rollNMove();
    }

    @Test
    void updateGUIMove() throws InterruptedException {
        updateGUIMove();
    }

    @Test
    void updateGUIBalanceAndFieldColor() {
        updateGUIBalanceAndFieldColor();
    }

    @Test
    void takingTurnMessage() {
        takingTurnMessage();
    }

    @Test
    public void takeTurn() throws InterruptedException {
        takingTurnMessage();
        rollNMove();
        updateGUIMove();
        updateGUIBalanceAndFieldColor();
    }

    @Test
    public void gameSetup() {
       gameSetup();
    }


    public static void main(String[] args) throws InterruptedException {
        String lang = args.length != 0 ? args[0] : "en";
        new GameTest();

    }
}


