/*
Egy Account attribútumai:
        számlaszám (accountNumber, String),
        egyenleg (balance, double),
        max levonható összeg (maxSubtract, double).
    Egy Account műveletei:
        példányosítás: számlaszám és egyenleg megadásával, a maxSubtract legyen 100000
        getterek
        setter a maxSubtract attribútumra
        subtract: egyenleg csökkentése egy megadott értékkel
        deposit: egyenleg növelése egy megadott értékkel
*/

package exceptionclass.bank;

public class Account {

    public static final String INVALID_AMOUNT = "Invalid amount!";
    private final String accountNumber;
    private double balance;
    private double maxSubtract;

    public Account(String accountNumber, double balance) {
        if (accountNumber == null) throw new IllegalArgumentException("Account number should not be null!");
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.maxSubtract = 100_000;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getMaxSubtract() {
        return maxSubtract;
    }

    public void setMaxSubtract(double maxSubtract) {
        if (maxSubtract < 0) throw new InvalidAmountBankOperationException(INVALID_AMOUNT);
        this.maxSubtract = maxSubtract;
    }

    public double subtract(double amount) {
        if (amount < 0) throw new InvalidAmountBankOperationException(INVALID_AMOUNT);
        if (amount > balance) throw new LowBalanceBankOperationException("Low balance!");
        balance -= amount;
        return balance;
    }

    public double deposit(double amount) {
        if (amount < 0) throw new InvalidAmountBankOperationException(INVALID_AMOUNT);
        balance += amount;
        return balance;
    }
}
