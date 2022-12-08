/*
Majd legyen egy School osztály! Ennek main() metódusában példányosíts egy TreeSet-et, amelynek konstruktor paraméterül adj át egy StudentComparator-t! Példányosíts le néhány tanulót, add őket a Set-hez és írd ki a kollekciót a konzolra, és nézd meg, hogy a tanulók magasság szerinti sorrendben fognak szerepelni!
        Ezután példányosíts egy Map<String, Integer>-t is, amely TreeMap legyen! Ennek adj át konstruktor paraméterül egy Collator-t, Magyarországra érvényes Locale-lal! Ehhez a Map-hez úgy add hozzá az előzőleg példányosított tanulókat, hogy a Map kulcsai a tanulók nevei, az értékek pedig a tanulók magasságai legyenek! Ezután írd ki ezt a kollekciót is a konzolra, és nézd meg, hogy a Map bejegyzései a tanulók nevei szerinti ábécésorrendben fognak szerepelni!
*/

package collectionscomp;

import java.text.Collator;
import java.util.*;

public class School {

    public static void main(String[] args) {
        Set<Student> students = new TreeSet<>(new StudentComparator());

        students.add(new Student("Jani", 167));
        students.add(new Student("Ibi", 157));
        students.add(new Student("Regi", 172));
        students.add(new Student("Peti", 190));
        students.add(new Student("Kati", 183));
        students.add(new Student("Évi", 153));
        students.add(new Student("Ági", 181));

        System.out.println(students);

        Map<String, Integer> mapStudents = new TreeMap<>(Collator.getInstance(new Locale("hu", "HU")));

        students.forEach(s -> mapStudents.put(s.name(), s.height()));

        System.out.println(mapStudents);
    }
}
