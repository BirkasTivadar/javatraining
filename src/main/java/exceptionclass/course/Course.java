/*
Készíts egy Course osztályt! A kurzusnak van neve (name) és kezdete (begin), ami SimpleTime típusú. Legyen konstruktora, ahol megkapja az adatokat, legyenek getterei, valamint legyen felüldefiniálva a toString-je úgy, hogy hh:mm: kurzusnév alakú legyen.
*/

package exceptionclass.course;

public record Course(String name, SimpleTime begin) {

    public Course {
        if (name == null) throw new IllegalArgumentException("Name is null!");
        if (begin == null) throw new IllegalArgumentException("Begin is null!");
    }

    @Override
    public String toString() {
        return begin.toString() + ": " + name;
    }
}
