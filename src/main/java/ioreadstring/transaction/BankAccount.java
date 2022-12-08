/*
Banki tranzakciók
        Ehhez a feladathoz két fájl tartalmát is fel kell dolgoznod. Az accounts.txt tartalmazza a bankszámla(BankAccount) adatokat. A transactions.txt állomány tartalmazza az utalásokat azaz, hogy melyik számlára mennyit utaltunk. A feladat, hogy olvasd be a számlaadatokat egy listába, majd egy másik metódusban hajtsd végre a tranzakciókat!
*/

package ioreadstring.transaction;

public class BankAccount {
    private final String name;
    private final String accountNumber;
    private int balance;

    public BankAccount(String name, String accountNumber, int balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int amount) {
        balance += amount;
    }
}
