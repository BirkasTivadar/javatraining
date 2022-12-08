/*
Készíts egy Bank osztályt! A Bank számlákat (Account-okat) tárol egy listában.
        az Account listát konstruktorban tudja megkapni
        képes adott számlaszámú Account egyenlegét csökkenteni egy megadott összeggel,
        képes adott számlaszámú Account egyenlegét növelni
*/

package exceptionclass.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<Account> accounts;

    public Bank(List<Account> accounts) {
        if (accounts == null) throw new IllegalArgumentException("Account list should not be null!");
        this.accounts = new ArrayList<>(accounts);
    }

    private Account getAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) return account;
        }
        throw new InvalidAccountNumberBankOperationException("Invalid account number!");

    }

    public void payment(String accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        account.subtract(amount);
    }

    public void deposit(String accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        account.deposit(amount);
    }
}

