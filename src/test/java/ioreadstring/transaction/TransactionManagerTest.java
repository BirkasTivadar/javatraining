package ioreadstring.transaction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionManagerTest {

    private final TransactionManager transactionManager = new TransactionManager();

    @Test
    void testUploadAccounts() {
        assertEquals(0, transactionManager.getAccountList().size());

        transactionManager.uploadListFromFile("src/test/resources/accounts.txt");

        assertEquals(5, transactionManager.getAccountList().size());
        assertEquals("Jack Doe", transactionManager.getAccountList().get(3).getName());
        assertEquals(234050200, transactionManager.getAccountList().get(1).getBalance(), 0.0000001);
    }

    @Test
    void makeTransactionsTest() {
        transactionManager.uploadListFromFile("src/test/resources/accounts.txt");

        transactionManager.makeTransactions("src/test/resources/transactions.txt");

        assertEquals(1201000, transactionManager.getAccountList().get(0).getBalance(), 0.0000001);
        assertEquals(721220, transactionManager.getAccountList().get(3).getBalance(), 0.00001);
    }
}
