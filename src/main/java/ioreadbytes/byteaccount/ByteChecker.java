/*
"A" betűk
        Adott a data.dat állomány melyben rengeteg karakter található. A feladatod, hogy számold meg benne az "a" betűket, a videóban látott eszközök segítségével.
*/


package ioreadbytes.byteaccount;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteChecker {
    public int readBytesAndFindAs(String file) {
        Path path = Path.of("src", "test", "resources", file);
        try (InputStream inputStream = new BufferedInputStream(Files.newInputStream(path))) {
            byte[] bytes = new byte[230];
            int size;
            int result = 0;
            while ((size = inputStream.read(bytes)) > 0) {
                for (int i = 0; i < size; i++) {
                    if (bytes[i] == 'a') result++;
                }
            }
            return result;
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file", ioException);
        }
    }
}
