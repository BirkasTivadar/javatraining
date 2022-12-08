/*
Karácsonyi bevásárlás
        Készíts egy ChristmasPresent osztályt, amelynek három attribútuma: az ajándék leírása, a személy neve, akinek az ajándékot szánják, valamint az ára! A ChristmasShopping osztálynak legyen egy ChristmasPresent lista attribútuma, amelyet konstruktorban kap meg! Legyen hozzá egy addNewPresent(ChristmasPresent present) metódusa, egy getter, valamint egy removeTooExpensivePresent(int maxPrice) metódus, amellyel törölni lehet a listából a paraméterként megadott árnál drágább ajándékokat! Ez utóbbit iterátorral valósítsd meg!
*/

package collectionsiterator.christmas;

public record ChristmasPresent(String description, String nameOfPerson, int price) {

}
