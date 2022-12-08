/*
Legyen egy InvalidBankOperationException, amely RuntimeException leszármazott! Legyen továbbá minden hibafajtára külön hiba osztály, amely mind az InvalidBankOperationException leszármazottja: InvalidAccountNumberBankOperationException, InvalidAmountBankOperationException, LowBalanceBankOperationException!
*/

package exceptionclass.bank;

public class InvalidAmountBankOperationException extends InvalidBankOperationException {

    public InvalidAmountBankOperationException(String message) {
        super(message);
    }
}
