/*
Osztálynapló
        A követező feladat egy osztálynapló nyilvántartása. A grades.txt fájl minden sora tartalmaz egy nevet és utána a tanuló jegyeit. Készíts egy Student osztályt mely a tanuló nevét és jegyeinek listáját képes tárolni! Legyen benne egy átlagszámító metódus, valamint egy metódus, ami képes eldönteni, hogy a tanuló jegyei emelkednek-e.
        Készíts egy SchoolRecordsManager osztályt, ami beolvassa fájlból az adatokat, eltárolja, és ezen felül még képes egy osztályátlag számítására is!
*/

package ioreader.grades;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private final String name;

    private final List<Integer> gradeList;

    public Student(String name, List<Integer> gradeList) {
        this.name = name;
        this.gradeList = new ArrayList<>(gradeList);
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGradeList() {
        return new ArrayList<>(gradeList);
    }

    public double average() {
        return gradeList.stream()
                .mapToInt(n -> n)
                .average()
                .orElse(0);
    }

    public boolean isIncreasing() {
        int length = gradeList.size();
        for (int i = 1; i < length; i++) {
            if (gradeList.get(i) < getGradeList().get(i - 1)) return false;
        }
        return true;
    }
}
