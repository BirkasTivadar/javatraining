/*
BankAccount
        Az iodatastream.bank csomagba készítsd el a BankAccount osztályt, melyben attribútumként a számlaszám (String), a tulajdonos neve (String) és az egyenleg (double) szerepel! A konstruktor mindhárom attribútumot várja, valamint mindegyikhez van getter.
*/

package iodatastream.bank;

public record BankAccount (String accountNumber, String owner, double balance) {
}
