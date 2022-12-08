/*
Készíts egy TemperatureReader osztályt, mely egyetlen readTemperatures() metódusa bináris fájlból beolvassa az eltárolt hőmérsékleteket, és egy Temperatures példánnyal tér vissza!
*/

package ioreadwritebytes.temperatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesReader {
    public Temperatures readTemperatures(String pathString) {
        Path path = Path.of(pathString);
        byte[] bytes;
        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file", ioException);
        }
        return new Temperatures(bytes);
    }

}
