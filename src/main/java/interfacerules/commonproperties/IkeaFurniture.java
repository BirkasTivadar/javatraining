/*
Majd készíts egy IkeaFurniture osztályt, melynek három attribútuma van: (fantázia)név, hosszúság és szélesség (ez utóbbiak lebegőpontos típusok)! Ez az osztály implementálja mindhárom interfészt, és valósítsa meg úgy a metódusait, hogy mindegyik egyenként a megfelelő attribútum értékét adja vissza! Legyen az osztálynak konstruktora is, mely beállítja az attribútumok értékét!
*/

package interfacerules.commonproperties;

public record IkeaFurniture(String name, double length, double width) implements Name, Length, Width {
}
