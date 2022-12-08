/*
Emberek
        A feladat egy szöveges állományból nevek beolvasása és eltárolása egy listába. A megoldáshoz két osztály kell megvalósítanod. A Human osztály reprezentál egy embert. Két adattagja vezeték- illetve keresztnév. A FileManager osztály felelős a fájl feldolgozásért. Egy Path típusú attribútumon keresztül érjük el a fájlt, míg a readFromFile() metódus felelős a beolvasásért és a Human objektumok létrehozásáért.
*/

package ioreadstring.names;

public record Human(String firstName, String lastName) {
}
