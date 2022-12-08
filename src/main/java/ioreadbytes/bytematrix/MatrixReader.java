/*
Mátrix
        Ebben a feladatban egy mátrix adatszerkezettel kell dolgoznod. Hozz létre egy listát, ami byte tömbök tárolására alkalmas! Tárold el ebben a listában a mátrix.dat állományból beolvasott, minden 1000 bájtot tartalmazó byte tömböt!
        Az állományban csak egyesek és nullák vannak. Írj egy metódust, ami visszaadja azon oszlopok számát, ahol több nulla, mint egyes van a mátrixban!
*/

package ioreadbytes.bytematrix;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MatrixReader {

    private final List<byte[]> myMatrix = new ArrayList<>();

    public List<byte[]> getMyMatrix() {
        return new ArrayList<>(myMatrix);
    }

    public void readBytesAndCreateMatrix(String file) {
        Path path = Path.of("src", "test", "resources", file);
        try (InputStream inputStream = new BufferedInputStream(Files.newInputStream(path))) {
            byte[] bytes = new byte[1000];
            while ((inputStream.read(bytes)) > 0) {
                myMatrix.add(bytes);
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file", ioException);
        }
    }

    public int numberOfColumnsWhereMoreZeros() {
        int result = 0;
        for (int i = 0; i < 1000; i++) {
            int counter = getZeroCounter(i);
            if (counter > myMatrix.size() / 2) result++;
        }
        return result;
    }

    private int getZeroCounter(int i) {
        int counter = 0;
        for (byte[] bytes : myMatrix) {
            if (bytes[i] == 48) counter++;
        }
        return counter;
    }
}
