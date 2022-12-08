/*
Bakancslista
        A bakancslistánkat egy szöveges fájlba írtuk, minden pontot külön-külön sorba. A bucketlist.txt a projekt gyökérkönyvtárában található. Listázd ki a fájl tartalmát a képernyőre a BucketList osztály main() metódusában! Amennyiben hiba történik a fájl megnyitásakor vagy olvasása közben, jelezd a hibát a felhasználónak!
*/

package filescanner.bucketlist;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class BucketList {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(Path.of("src", "main", "resources", "bucketlist.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Cannot read file", ioException);
        }

//        try (Scanner scanner = new Scanner(Objects.requireNonNull(BucketList.class.getResourceAsStream("/bucketlist.txt")))) {
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                System.out.println(line);
//            }
//        }
    }
}
