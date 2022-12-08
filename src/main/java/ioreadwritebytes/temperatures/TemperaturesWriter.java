/*
Ugyanennek mintájára készíts egy TemperaturesWriter osztályt, amelynek a writeTemperatures() metódusa a paraméterként kapott Temperatures példányból bináris fájlba írja a hőmérsékleti adatokat!
*/

package ioreadwritebytes.temperatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesWriter {
    public void writeTemperatures(Temperatures temperatures, String pathString) {
        Path path = Path.of(pathString);
        try {
            Files.write(path, temperatures.getData());
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not write file", ioException);
        }
    }
}
