/*
Darabokban érkező kép
        Hozz létre egy ImageAssembler osztályt, melyben a makeImageFile() metódus a paraméterben a kép részleteit byte[][]-ként kapja meg, majd a részeket kiírja egyetlen image.png nevű fájlba a Path-ként kapott mappába!
*/

package iowritebytes.imageassembler;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageAssembler {
    public void makeImageFile(byte[][] source, Path folder) {
        Path file = folder.resolve("image.png");
        try (OutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(file))) {
            for (byte[] bytes : source) {
                outputStream.write(bytes);
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Cannot write file", ioException);
        }

    }
}
