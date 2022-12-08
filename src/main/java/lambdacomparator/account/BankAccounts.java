/*
Bankszámlák lekérdezése
        Készíts egy account.BankAccount osztályt accountNumber, nameOfOwner és balance attribútumokkal! Az osztály implementálja a Comparable interfészt, és a compareTo metódus definiáljon egy természetes rendezettséget az osztály számára a számlaszámok alapján! Készíts egy account.BankAccounts osztályt, mely konstruktorban BankAccount listát vár.
        Az osztály metódusai rendre új listát készítenek, rendezik a következő szabályok alapján, és a rendezett listát adják vissza:
        listBankAccountsByAccountNumber(): Rendezés bankszámlaszám alapján.
        listBankAccountsByBalance(): Rendezés rendelkezésre álló összeg alapján, de előjeltől függetlenül.
        listBankAccountsByBalanceDesc(): Rendezés rendelkezésre álló összeg alapján, az előjel számítson, de csökkenő sorrendben!
        listBankAccountsByNameThenAccountNumber(): Rendezés név alapján, de ha a név megegyezik, akkor bankszámlaszám alapján. Amennyiben nincs kitöltve a név (értéke null), elöl szerepeljen!
        Kizárólag lambda kifejezéseket vagy method reference-eket használj!
        Használd a következő metódusokat (persze a megfelelő paraméterezéssel): Comparator.naturalOrder(), Comparator.comparing(), Comparator.reversed(), Comparator.nullsFirst(), Comparator.thenComparing()!
*/

package lambdacomparator.account;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public record BankAccounts(List<BankAccount> bankAccounts) {
    public BankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = new ArrayList<>(bankAccounts);
    }

    public List<BankAccount> listBankAccountsByAccountNumber() {
        List<BankAccount> result = new ArrayList<>(bankAccounts);
        result.sort(Comparator.naturalOrder());
        return result;
    }

    public List<BankAccount> listBankAccountsByBalance() {
        List<BankAccount> result = new ArrayList<>(bankAccounts);
        result.sort(Comparator.comparing((ba -> Math.abs(ba.balance()))));
        return result;
    }

    public List<BankAccount> listBankAccountsByBalanceDesc() {
        List<BankAccount> result = new ArrayList<>(bankAccounts);
//        result.sort(Comparator.comparingDouble(ba -> -ba.balance()));
        result.sort(Comparator.comparingDouble(BankAccount::balance).reversed());
        return result;
    }

    public List<BankAccount> listBankAccountsByNameThenAccountNumber() {
        List<BankAccount> result = new ArrayList<>(bankAccounts);
        Collator nameCollator = Collator.getInstance(new Locale("hu", "HU"));
        result.sort(Comparator.comparing(BankAccount::nameOfOwner, Comparator.nullsFirst(nameCollator))
                .thenComparing(BankAccount::accountNumber));
        return result;
    }
}
