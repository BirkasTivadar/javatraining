/*
Napi tranzakciók
        Az iozip.transactions csomagba készíts egy Transaction immutable osztályt, melyben a tranzakció azonosítója (long id), a tranzakció pontos időpontja (LocalDateTime time), az érintett bankszámla száma (String account) és a tranzakció összege (double amount) található.
        A TransactionFileManager osztály saveTransactions() metódusa a paraméterként kapott Path-ra elmenti a Transaction listában kapott tranzakciókat tömörítve. Minden tranzakció külön szöveges fájlba kerüljön! A fájl neve a tranzakció azonosítója legyen! Tartalma sortöréssel (\n) elválasztva az időpont, a bankszámlaszám és az összeg.
        Például:
        2018-02-13T15:08:43
        10092365-37255375-33310000
        23000.0
*/

package iozip.transactions;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TransactionFileManager {
    public void saveTransactions(Path file, List<Transaction> transactions) {
        try (ZipOutputStream outputStream = new ZipOutputStream(
                new BufferedOutputStream(Files.newOutputStream(file)))) {
            for (Transaction transaction : transactions) {
                outputStream.putNextEntry(new ZipEntry(Long.toString(transaction.id())));
                String output = transaction.time().toString() + System.lineSeparator() + transaction.account() + System.lineSeparator() + transaction.amount();
                outputStream.write(output.getBytes());
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not write file", ioException);
        }
    }
}
