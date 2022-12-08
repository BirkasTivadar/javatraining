/*
Egy könyvtár nyilvántartása a könyvek leltári számát, szerzőjét, címét és a kiadás évét tartalmazza. Készíts egy Book osztályt, mely konstruktorában megkapja ezeket az adatokat! Minden adata lekérdezhető, de egyik sem módosítható.
*/

package filescanner.library;

public record Book(String regNum, String author, String title, int yearOfPublish) {
}
