/*
Hőmérsékleti statisztika
        Az előző 365 nap hőmérsékleti adatait fájlban tároljuk. A Temperatures osztály attribútumában ezek találhatók egy byte[]-ben. Az osztály konstruktorban kapja meg a hőmérsékleti adatokat. A getYearAverage() metódusa a teljes év átlaghőmérsékletét adja vissza, a getMonthAverage() az utolsó 30 napét. Készíts egy TemperatureReader osztályt, mely egyetlen readTemperatures() metódusa bináris fájlból beolvassa az eltárolt hőmérsékleteket, és egy Temperatures példánnyal tér vissza! Ugyanennek mintájára készíts egy TemperaturesWriter osztályt, amelynek a writeTemperatures() metódusa a paraméterként kapott Temperatures példányból bináris fájlba írja a hőmérsékleti adatokat!
*/

package ioreadwritebytes.temperatures;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class Temperatures {

    private final Byte[] data;

    public Temperatures(byte[] data) {
        this.data = ArrayUtils.toObject(data);
    }

    public byte[] getData() {
        return ArrayUtils.toPrimitive(data);
    }

    public double getYearAverage() {
        return Arrays.stream(data)
                .mapToInt(Byte::intValue)
                .average()
                .orElse(0);
    }

    public double getMonthAverage() {
        return Arrays.stream(data)
                .skip(335)
                .mapToInt(Byte::intValue)
                .average()
                .orElse(0);
    }
}
