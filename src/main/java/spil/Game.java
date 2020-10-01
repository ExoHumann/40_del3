package spil;

public class Game {
    private final Player player1;
    private final Player player2;
    private final Dice cDice;
    private final Dice pDice;
    private boolean twoSixesP1 = false;
    private boolean twoSixesP2 = false;
    private boolean gameEnd = false;


    public Game(GameGUI gui, Dice cDice, Dice pDice,Player player1,Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.cDice = cDice;
        this.pDice = pDice;
        play();
    }


    private void play() {
        
        while(!gameEnd) {
            do {
                if (GameGUI.hasReachedGoalP1) {
                    if (GameGUI.rollDiceAction(player1)) {
                        pDice.roll();
                        GameGUI.showDice(pDice.getDice1(), pDice.getDice2());
                        if (pDice.getEquals()) {
                            //Game end
                            gameEnd = true;
                            GameGUI.gameEnd(player1);
                        }
                    }
                } else {
                    if (GameGUI.rollDiceAction(player1)) {
                        pDice.roll();
                        GameGUI.showDice(pDice.getDice1(), pDice.getDice2());
                        if (pDice.getEquals()) {
                            if (pDice.getDice1() == 1) {
                                GameGUI.moveToStart(player1);
                            } else if (pDice.getDice1() == 6) {
                                if (twoSixesP1) {
                                    //Player 1 rolled two sixes two times in a row
                                    GameGUI.gameEnd(player1);
                                    gameEnd = true;
                                } else {
                                    twoSixesP1 = true;
                                }
                            } else {
                                GameGUI.movePlayer(player1, pDice.getSum());
                            }
                        } else {
                            GameGUI.movePlayer(player1, pDice.getSum());
                        }
                    }
                }
            }
            while (pDice.getEquals()) ;

            do {
                if (GameGUI.hasReachedGoalP2) {
                    if (GameGUI.rollDiceAction(player2)) {
                        cDice.roll();
                        GameGUI.showDice(cDice.getDice1(), cDice.getDice2());
                        if (cDice.getEquals()) {
                            //Game end
                            gameEnd = true;
                            GameGUI.gameEnd(player2);
                        }
                    }
                } else {
                    if (GameGUI.rollDiceAction(player2)) {
                        cDice.roll();
                        GameGUI.showDice(cDice.getDice1(), cDice.getDice2());
                        if (cDice.getEquals()) {
                            if (cDice.getDice1() == 1) {
                                GameGUI.moveToStart(player2);
                            } else if (cDice.getDice1() == 6) {
                                if (twoSixesP2) {
                                    //Player 2 rolled two sixes two times in a row
                                    GameGUI.gameEnd(player2);
                                    gameEnd = true;
                                } else {
                                    twoSixesP2 = true;
                                }
                            } else {
                                GameGUI.movePlayer(player2, cDice.getSum());
                            }
                        } else {
                            GameGUI.movePlayer(player2, cDice.getSum());
                        }
                    }
                }
            }
            while (cDice.getEquals());
        }
    }
}