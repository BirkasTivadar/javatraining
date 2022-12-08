/*
Majd legyen egy PhysicalEducation osztály, amelyben egy Set<Integer> getOrderInLessons(List<Student>) metódus, amely egy TreeSet-ben adja vissza a diákok magasságait, így érve el, hogy azok növekvő sorrendben legyenek! Az osztály main() metódusában írd is ki a visszakapott értéket a konzolra és ellenőrizd, hogy tényleg növekvő sorrendben vannak-e a számok!
*/

package collectionsset;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PhysicalEducation {

    public Set<Integer> getOrderInLessons(List<Student> students) {
        return students.stream()
                .map(Student::height)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Kiss Ibolya", 160),
                new Student("Ambrus János", 176),
                new Student("Nagy Anikó", 160),
                new Student("Kovács Péter", 182),
                new Student("Kovács Nóra", 152)
        );

        PhysicalEducation physicalEducation = new PhysicalEducation();

        System.out.println(physicalEducation.getOrderInLessons(students));
    }
}
