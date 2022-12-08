/*
Gyakorlati feladat - Adatbázis konfiguráció beolvasása
        Írj egy DatabaseConfiguration osztályt, mely properties állományból betölti az adatbázis beállításokat, majd le lehet ezeket kérdezni! Az osztály tároljon egy Properties típusú attribútumot! Kétféle konstruktorral lehessen példányt létrehozni: legyen egy File típusú paramétert váró konstruktora, amely a megadott elérési útvonalon lévő mappában keresi a fájlt, és abból tölti be a Properties-t, valamint legyen egy paraméter nélküli konstruktora, amellyel pedig egy classpath-on lévő properties fájlból lehet betölteni! A betöltés a konstruktorban történjen!
        Figyelj a karakterkódolásra a fájlból való betöltés közben! IDEA-ban, hogy a properties fájlt UTF-8 kódolással hozza létre, a File / Settings / Editor / File Encodings ablakban a "Default encoding for properties files" értékét kell UTF-8-ra állítani!
        Az osztályban legyenek külön metódusok arra is, hogy az egyes kulcsokhoz tartozó értékek egyenként lekérdezhetőek legyenek!
*/

package properties.database;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class DatabaseConfiguration {

    private final Properties config = new Properties();

    public DatabaseConfiguration() {
        try (InputStream inputStream = DatabaseConfiguration.class.getResourceAsStream("/db.properties")) {
            load(inputStream);
        } catch (IOException ioException) {
            throw new IllegalArgumentException("Cannot read file", ioException);
        }
    }

    public DatabaseConfiguration(File file) {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            load(inputStream);
        } catch (IOException ioException) {
            throw new IllegalArgumentException("Cannot read file", ioException);
        }
    }

    private void load(InputStream inputStream) throws IOException {
        try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            this.config.load(inputStreamReader);
        }
    }

    public String getHost() {
        return config.getProperty("db.host");
    }

    public int getPort() {
        return Integer.parseInt(config.getProperty("db.port"));
    }

    public String getSchema() {
        return config.getProperty("db.schema");
    }
}
