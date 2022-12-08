/*
Tornasor és névsor
        Készíts egy Student osztályt, amelynek két attribútuma legyen: név és magasság (centiméterben)! Írd felül az osztály toString() metódusát! Készíts egy StudentComparator osztályt is, amely implementálja a Comparator interfészt, és úgy valósítja meg annak compare() metódusát, hogy a tanulókat a magasságuk szerint hasonlítja össze! Majd legyen egy School osztály! Ennek main() metódusában példányosíts egy TreeSet-et, amelynek konstruktor paraméterül adj át egy StudentComparator-t! Példányosíts le néhány tanulót, add őket a Set-hez és írd ki a kollekciót a konzolra, és nézd meg, hogy a tanulók magasság szerinti sorrendben fognak szerepelni!
        Ezután példányosíts egy Map<String, Integer>-t is, amely TreeMap legyen! Ennek adj át konstruktor paraméterül egy Collator-t, Magyarországra érvényes Locale-lal! Ehhez a Map-hez úgy add hozzá az előzőleg példányosított tanulókat, hogy a Map kulcsai a tanulók nevei, az értékek pedig a tanulók magasságai legyenek! Ezután írd ki ezt a kollekciót is a konzolra, és nézd meg, hogy a Map bejegyzései a tanulók nevei szerinti ábécésorrendben fognak szerepelni!
*/

package collectionscomp;

public record Student(String name, Integer height) {

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
