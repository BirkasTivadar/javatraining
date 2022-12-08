/*
Készíts egy account.BankAccount osztályt accountNumber, nameOfOwner és balance attribútumokkal! Az osztály implementálja a Comparable interfészt, és a compareTo metódus definiáljon egy természetes rendezettséget az osztály számára a számlaszámok alapján!
*/

package lambdacomparator.account;

import org.jetbrains.annotations.NotNull;

public record BankAccount(String accountNumber, String nameOfOwner, double balance) implements Comparable<BankAccount> {
    @Override
    public int compareTo(@NotNull BankAccount other) {
        return this.accountNumber.compareTo(other.accountNumber);
    }
}
