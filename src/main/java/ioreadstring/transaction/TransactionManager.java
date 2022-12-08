package ioreadstring.transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private final List<BankAccount> accountList = new ArrayList<>();
    public List<BankAccount> getAccountList() {
        return new ArrayList<>(accountList);
    }

    public void uploadListFromFile(String accountsFile) {
        Path path = Path.of(accountsFile);
        try {
            List<String> lines = Files.readAllLines(path);
            lines.forEach(l -> accountList.add(new BankAccount(l.split(";")[0], l.split(";")[1], Integer.parseInt(l.split(";")[2]))));
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file", ioException);
        }
    }

    public void makeTransactions(String transactionsFile) {
        Path path = Path.of(transactionsFile);
        try {
            List<String> lines = Files.readAllLines(path);
            setTransactions(lines);
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file", ioException);
        }
    }

    private void setTransactions(List<String> lines) {
        accountList.forEach(a -> actualAccountTransactions(lines, a));
    }

    private void actualAccountTransactions(List<String> lines, BankAccount account) {
        lines.stream()
                .filter(l -> l.split(";")[0].equals(account.getAccountNumber()))
                .forEach(l -> account.setBalance(Integer.parseInt(l.split(";")[1])));
    }
}
