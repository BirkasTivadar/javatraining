/*
Hosszú szavak
        Az első feladatban hosszú szavakat kell kezelned StringWriter segítségével. Írj egy metódust, ami egy Writer-t és egy listát kap paraméterül, és minden lista beli elem után írja a szó hosszát! Majd írj egy metódust, ami csak egy listát vár, és az előzőleg megírt metódust használja a paraéterül kapott listával és egy példányosított StringWriter-rel!
*/

package iostringwriter.longwords;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class LongWordService {
    public String writeWithStringWriter(List<String> words) {
        StringWriter writer = new StringWriter();
        return writeWithWriter(writer, words);
    }

    private String writeWithWriter(Writer writer, List<String> words) {
        try (writer) {
            for (String word : words) {
                writer.write(word);
                writer.write(String.valueOf(word.length()));
                writer.write("\n");
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not write", ioException);
        }
        return writer.toString();
    }
}
