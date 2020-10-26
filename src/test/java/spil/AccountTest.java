package spil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void withdraw() {
        Account myAccount = new Account(1);
        myAccount.withdraw(2);
        int res = myAccount.getBalance();
        Assertions.assertEquals(0,res);
    }

    @Test
    void deposit() {
        Account myAccount = new Account(1);
        myAccount.deposit(-2);
        int res = myAccount.getBalance();
        Assertions.assertEquals(0,res);
    }
}