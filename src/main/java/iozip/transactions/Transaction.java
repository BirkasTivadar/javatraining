/*
Napi tranzakciók
        Az iozip.transactions csomagba készíts egy Transaction immutable osztályt, melyben a tranzakció azonosítója (long id), a tranzakció pontos időpontja (LocalDateTime time), az érintett bankszámla száma (String account) és a tranzakció összege (double amount) található.
*/

package iozip.transactions;

import java.time.LocalDateTime;

public record Transaction(long id, LocalDateTime time, String account, double amount) {
}
