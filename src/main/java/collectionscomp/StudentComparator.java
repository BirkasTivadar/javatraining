/*
Készíts egy StudentComparator osztályt is, amely implementálja a Comparator interfészt, és úgy valósítja meg annak compare() metódusát, hogy a tanulókat a magasságuk szerint hasonlítja össze!
*/

package collectionscomp;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.height().compareTo(o2.height());
    }
}
