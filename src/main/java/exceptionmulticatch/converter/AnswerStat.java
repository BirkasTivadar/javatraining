/*
Majd pedig kell egy AnswerStat osztály, amely az igaz/hamis adatokon számol statisztikát, jelen esetben az igaz értékek százalékos arányát.
        Az osztály konstruktora paraméterben kapjon egy BinaryStringConverter-t!
        Legyen egy convert(String) metódus, amely meghívja a binaryStringToBooleanArray metódust, és elkapja a konvertálás során előforduló NullPointerException-t vagy IllegalArgumentException-t, majd tovább dobja azt, becsomagolva egy InvalidBinaryStringException-be (amely egy saját, a RuntimeException-ból származó kivételosztály)! Mivel mindkét hibafajtára ugyanazt kell csinálni, használja a multi-catch-et!
        Legyen egy int answerTruePercent(String answers) metódusa, amely a paramétert boolean tömbbé alakítja, majd meghatározza és visszaadja az igaz értékek százalékos arányát egészre kerekítve!
*/

package exceptionmulticatch.converter;

public class AnswerStat {

    private final BinaryStringConverter binaryStringConverter;

    public AnswerStat(BinaryStringConverter binaryStringConverter) {
        this.binaryStringConverter = binaryStringConverter;
    }


    public boolean[] convert(String str) {
        try {
            return binaryStringConverter.binaryStringToBooleanArray(str);
        } catch (NullPointerException | IllegalArgumentException e) {
            throw new InvalidBinaryStringException(e);
        }
    }

    int answerTruePercent(String answers) {
        double size = answers.length();
        int trues = 0;
        boolean[] booleanArray = convert(answers);
        for (boolean b : booleanArray) {
            trues += b ? 1 : 0;
        }
        return (int) Math.round(trues / size * 100);
    }
}
