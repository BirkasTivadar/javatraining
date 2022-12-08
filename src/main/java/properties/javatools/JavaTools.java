/*
Gyakorlati feladat - Java eszközök nyilvántartása
        Egy properties állományban tárold el a különböző Java eszközök leírásait a következő formátumban:
        jdk.name = Java Development Kit
        jdk.url = http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html
        maven.name = Apache Maven
        maven.url = https://maven.apache.org/
        junit.name = JUnit
        junit.url = http://junit.org/junit4/

        Írj egy JavaTools osztályt, mely betölti ezen eszközöket a properties állományból! A betöltés a konstruktorban történjen, egy classpath-on lévő fájlból!
        Legyen egy Set<String> getToolKeys() metódusa, mely visszaadja az eszközök kulcsait (jdk, maven, junit)!
        Legyen egy Set<String> getToolNames() metódusa, mely visszaadja az eszközöket (Apache Maven, Java Development Kit, JUnit)!
        Legyen egy String getName(String key) metódusa, mely kulcs alapján visszaadja az eszközt (pl. ha a kulcs az, hogy jdk, akkor a visszaadott érték Java Development Kit)!
        Legyen egy String getUrl(String key) metódusa, mely kulcs alapján visszaadja az url-t (pl. ha a kulcs az, hogy jdk, akkor a visszaadott érték http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html)!
*/

package properties.javatools;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

public class JavaTools {

    private final Properties tools = new Properties();

    public JavaTools() {
        try (InputStream inputStream = JavaTools.class.getResourceAsStream("/javatools.properties")) {
            load(inputStream);
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file", ioException);
        }
    }

    private void load(InputStream inputStream) throws IOException {
        try (InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            tools.load(reader);
        }
    }

    public Set<String> getToolKeys() {
        return tools.stringPropertyNames()
                .stream()
                .filter(k -> k.contains("name"))
                .map(k -> k.substring(0, k.indexOf(".")))
                .collect(Collectors.toSet());
    }

    public Set<String> getTools() {
        return getToolKeys()
                .stream()
                .map(this::getName)
                .collect(Collectors.toSet());
    }

    public String getName(String key) {
        return tools.getProperty(String.format("%s.name", key));
    }

    public String getUrl(String key) {
        return tools.getProperty(String.format("%s.url", key));
    }
}
