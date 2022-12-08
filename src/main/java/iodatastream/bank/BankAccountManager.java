/*
BankAccount
        Az iodatastream.bank csomagba készítsd el a BankAccount osztályt, melyben attribútumként a számlaszám (String), a tulajdonos neve (String) és az egyenleg (double) szerepel! A konstruktor mindhárom attribútumot várja, valamint mindegyikhez van getter.
        Készíts egy BankAccountManager osztályt, melyben csak 2 metódus van. A saveAccount() metódus egy BankAccount példány állapotát menti a bankszámla számával megegyező nevű .dat kiterjesztésű fájlba DataOutputStream segítségével. Paraméterként megkapja a mentési mappát is Path objektumknt. A loadAccount() ugyanilyen szerkezetű fájlból betölti egy BankAccount adatait, és paraméterként csak egy InputStream-et vár.
        A fájl minden adatot tartalmazzon az alábbi sorrendben: számlaszám, tulajdonos neve, egyenleg!
*/

package iodatastream.bank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankAccountManager {
    public void saveAccount(BankAccount account, Path folder) {
        String fileName = String.format("%s.dat", account.accountNumber());
        Path file = folder.resolve(fileName);
        try (DataOutputStream outputStream = new DataOutputStream(
                new BufferedOutputStream(Files.newOutputStream(file)))) {
            outputStream.writeUTF(account.accountNumber());
            outputStream.writeUTF(account.owner());
            outputStream.writeDouble(account.balance());
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not write file", ioException);
        }
    }

    public BankAccount loadAccount(InputStream is) {
        try (DataInputStream inputStream = new DataInputStream(
                new BufferedInputStream(is))) {
            String accountNumber = inputStream.readUTF();
            String owner = inputStream.readUTF();
            double balance = inputStream.readDouble();
            return new BankAccount(accountNumber, owner, balance);
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file", ioException);
        }
    }
}
