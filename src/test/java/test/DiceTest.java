package test;

import Model.Dice;
import Model.Die;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    Die die1 = new Die(12,0);
    Die die2 = new Die(12,0);

    Dice dice = new Dice(0, 0);


    @org.junit.jupiter.api.Test
    void roll() {
        die1.roll();
        die2.roll();

        dice.setDice(die1.getFaceValue(), die2.getFaceValue());
        int res = dice.getSum();

        assertEquals(dice.getDie1() + dice.getDie2(), res);
    }

    @org.junit.jupiter.api.Test
    void getEquals() {
        dice.setDice(1,1);
        boolean res = dice.getDie1() == dice.getDie2();
        assertTrue(res);
    }

    @org.junit.jupiter.api.Test
    void setDice() {
        dice.setDice(6,6);
        int res = dice.getDie1();
        assertEquals(6,res);
    }


    @org.junit.jupiter.api.Test
    void getSum() {
        dice.setDice(3,5);
        int res = dice.getDie1() + dice.getDie2();
        assertEquals(8,res);
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        int str = dice.roll();
        System.out.println(str);
        assertEquals(str,dice.getSum());
    }
}