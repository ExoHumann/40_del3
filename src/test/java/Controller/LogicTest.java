package Controller;

import Model.FieldList;
import Model.PlayerList;
import Translation.Translator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LogicTest {

    PlayerList pl;
    FieldList fl;
    Logic lg;
    Translator tr;


    @BeforeEach
    void setUp() {
        tr = new Translator("en");
        pl = new PlayerList(2);
        fl = new FieldList(tr);
        lg = new Logic(tr);
    }

    //TC01
    @Test
    void moveOverStart(){
        //Set player start balance
        pl.getAccount(0).setBalance(20);
        //Move player to sixth field
        lg.movePlayer(pl,fl,6,0);
        //Move player over start
        lg.movePlayer(pl,fl,18,0);
        //Get the players balance
        int balance = pl.getAccount(0).getBalance();
        assertEquals(22,balance);
    }

    @Test
    void movePlayer() {
        //Move player to sixth field (In Prison)
        lg.movePlayer(pl,fl,6,0);
        int pos = lg.getPos();
        assertEquals(6,pos);
    }

    @Test
    void moveAmount() {
        //Move player to field 15 (Chance)
        lg.movePlayer(pl,fl,15,0);
        //See how many moves to field 4
        int move = lg.moveAmount(4,fl);
        //Should be 13
        assertEquals(13,move);
    }

    @Test
    void winConditionTrue() {
        for (int i = 0; i < pl.getAccounts().length; i++) {
            pl.getAccount(i).setBalance(20);
        }
        pl.getAccount(0).setBalance(0);
        assertTrue(lg.winCondition(pl));
    }

    @Test
    void winConditionFalse() {
        for (int i = 0; i < pl.getAccounts().length; i++) {
            pl.getAccount(i).setBalance(20);
        }
        assertFalse(lg.winCondition(pl));
    }

    @Test
    void getNearbyFields() {
        //Move player to field 16
        lg.movePlayer(pl,fl,16,0);
        //Get nearby fields
        int[] fields = lg.getNearbyFields(pl.getPlayerList(0));
        //Should be 15 and 17
        assertArrayEquals(new int[]{15, 17},fields);
    }

    @Test
    void jailPlayerInJail() {
        //Jail the player
        lg.jailPlayer(pl.getPlayerList(0));
        //Check if the player is in jail
        assertTrue(pl.getPlayerList(0).getInJail());
    }
    @Test
    void jailPlayerNotInJail() {
        //Jail the player
        lg.jailPlayer(pl.getPlayerList(0));
        //Unjail the player
        lg.jailPlayer(pl.getPlayerList(0));
        //Check if the player is in jail
        assertFalse(pl.getPlayerList(0).getInJail());
    }
}