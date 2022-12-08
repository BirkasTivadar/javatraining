/*
Zenekarok
        Ebben a fájl olvasását és írását is gyakorolhatod. Adott a bands_and_years.txt állomány, melyben zenekarok nevét és alapítási évét találod. Készíts egy metódust melynek a paramétere egy fájl és egy évszám! Ez a metódus ki fogja írni a fájlba az évszámnál régebben alakult zenekarokat. Megoldási javaslat, hogy készíts egy privát metódust, ami kigyűjti ezeket a zenekarokat egy listába. Minden zenekart egy Band objektum reprezentál, melynek attribútumai a név és az évszám.
*/

package iowriter.music;

public record Band(String name, int year) {
}
