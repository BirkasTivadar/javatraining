/*
Paraméterek ellenőrzée
    Készíts egy sum.NumbersSum osztályt, melyben két túlterhelt metódus van: getSum(int[] numbers) és getSum(String[] numbers)! Mindkét metódus dobjon IllegalArgumentException kivételt, ha a kapott paraméter null értékű! A String[] paraméterű metódus dobjon IllegalArgumentException-t akkor is, ha a kapott tömb valamely eleme nem alakítható számmá! A dobott kivételek tartalmazzák a megfelelő üzenetet is! Végül mindkét metódus adja vissza a paraméterül kapott tömbben szereplő számok összegét!
    Írd meg a tesztet is a metódusok működésének ellenőrzésére! Legyen teszteset minden lehetséges szélsőséges esetre!
*/

package exceptions.sum;

import java.util.Arrays;

public class NumbersSum {

    public int getSum(int[] numbers) {
        if (numbers == null) throw new IllegalArgumentException("Parameter should not be null!");

        return Arrays.stream(numbers).sum();
    }

    public int getSum(String[] numbers) {
        if (numbers == null) throw new IllegalArgumentException("Parameter should not be null!");

        int result = 0;
        for (String stringNumber : numbers) {
            try {
                int number = Integer.parseInt(stringNumber);
                result += number;
            } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("Illegal numbers!", nfe);
            }
        }
        return result;
    }


}
