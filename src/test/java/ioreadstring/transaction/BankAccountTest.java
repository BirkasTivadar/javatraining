package ioreadstring.transaction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankAccountTest {

    @Test
    void createAccountTest() {
        BankAccount bankAccount = new BankAccount("John Doe", "1234-1234-1234-1234", 2500);
        assertEquals("John Doe", bankAccount.getName());
        assertEquals("1234-1234-1234-1234", bankAccount.getAccountNumber());
    }

    @Test
    void addBalanceTest() {
        BankAccount bankAccount = new BankAccount("John Doe", "1234-1234-1234-1234", 2500);

        assertEquals(2500, bankAccount.getBalance(), 0.0000001);

        bankAccount.setBalance(100);
        assertEquals(2600, bankAccount.getBalance(), 0.0000001);
    }
}
