package Controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceControllerTest {

    @Test
    public void drawCard() {
        ChanceController chanceController = new ChanceController();
        chanceController.Shuffle();

        int deckSize = chanceController.deck.size();
        int actual = 0;
        // get the chanceCardIndex card in the array of cards
        int chanceCardIndex = 2;
        int firstCard = chanceController.deck.get(chanceCardIndex%deckSize);

        for (int i = 0; i < (deckSize+chanceCardIndex); i++) {
            chanceController.drawCard();
            chanceController.printDeck();
            actual = chanceController.deck.get((i+1)%chanceController.deck.size());
        }

        System.out.println("Expected " + firstCard);
        System.out.println("Actual " + actual);

        assertEquals(firstCard, actual);
    }

}