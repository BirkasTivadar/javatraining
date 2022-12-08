/*
Konverter
    Adatbázisban kódolva tárolunk több igaz, hamis értéket egyetlen szöveges adatban, ahol ‘0’ karakter a hamis és ‘1’ karakter az igaz. Készíteni kell tehát konvertert, amely átalakítja a szöveges adatot boolean tömb adattá. A konvertáláshoz két osztályt is kell készíteni. Legyen egy BinaryStringConverter osztály, amelynek van egy public boolean[] binaryStringToBooleanArray(String) és egy public String booleanArrayToBinaryString(boolean[]) metódusa! A String-ből konvertáló IllegalArgumentException-t dob, ha a String-ben nem csupa 0 és 1 van. A boolean[]-ből konvertáló pedig IllegalArgumentException-t dob, ha a tömb üres. Mindkét metódus dobjon NullPointerException-t a megfelelő tájékoztató üzenettel, ha null értékű paramétert kap!
        Majd pedig kell egy AnswerStat osztály, amely az igaz/hamis adatokon számol statisztikát, jelen esetben az igaz értékek százalékos arányát.
        Az osztály konstruktora paraméterben kapjon egy BinaryStringConverter-t!
        Legyen egy convert(String) metódus, amely meghívja a binaryStringToBooleanArray metódust, és elkapja a konvertálás során előforduló NullPointerException-t vagy IllegalArgumentException-t, majd tovább dobja azt, becsomagolva egy InvalidBinaryStringException-be (amely egy saját, a RuntimeException-ból származó kivételosztály)! Mivel mindkét hibafajtára ugyanazt kell csinálni, használja a multi-catch-et!
        Legyen egy int answerTruePercent(String answers) metódusa, amely a paramétert boolean tömbbé alakítja, majd meghatározza és visszaadja az igaz értékek százalékos arányát egészre kerekítve!
*/

package exceptionmulticatch.converter;

public class BinaryStringConverter {

    public boolean[] binaryStringToBooleanArray(String binaryString) {
        if (binaryString == null) throw new NullPointerException("Binary string is null.");
        return getBooleans(binaryString);
    }

    private static boolean[] getBooleans(String str) {
        char[] binaryArray = str.toCharArray();
        int size = str.length();
        boolean[] result = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (binaryArray[i] != '0' && binaryArray[i] != '1')
                throw new IllegalArgumentException("Binary string is not valid.");
            result[i] = binaryArray[i] == '1';
        }
        return result;
    }

    public String booleanArrayToBinaryString(boolean[] booleanArray) {
        if (booleanArray == null) throw new NullPointerException("Boolean array is null.");
        if (booleanArray.length == 0) throw new IllegalArgumentException("Boolean array is empty.");
        StringBuilder result = new StringBuilder();
        for (boolean b : booleanArray) {
            result.append(b ? "1" : "0");
        }
        return result.toString();
    }
}
