/*
Legyen egy InvalidBankOperationException, amely RuntimeException leszármazott! Legyen továbbá minden hibafajtára külön hiba osztály, amely mind az InvalidBankOperationException leszármazottja: InvalidAccountNumberBankOperationException, InvalidAmountBankOperationException, LowBalanceBankOperationException!
*/

package exceptionclass.bank;

public class LowBalanceBankOperationException extends InvalidBankOperationException {

    public LowBalanceBankOperationException(String message) {
        super(message);
    }
}
