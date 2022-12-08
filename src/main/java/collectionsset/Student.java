/*
Tornasor
        Hozz létre egy Student osztályt, amelynek két attribútuma legyen: a diák neve és centiméterekben mért magassága! Majd legyen egy PhysicalEducation osztály, amelyben egy Set<Integer> getOrderInLessons(List<Student>) metódus, amely egy TreeSet-ben adja vissza a diákok magasságait, így érve el, hogy azok növekvő sorrendben legyenek! Az osztály main() metódusában írd is ki a visszakapott értéket a konzolra és ellenőrizd, hogy tényleg növekvő sorrendben vannak-e a számok!
*/

package collectionsset;

public record Student(String name, int height) {
}
