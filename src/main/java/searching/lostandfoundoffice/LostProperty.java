/*
Készíts egy LostProperty osztályt, amelynek három attribútuma egy regisztrációs szám, egy rövid leírás az elveszett tárgyról és a talált tárgyak osztályára való bekerülésének dátuma!
*/

package searching.lostandfoundoffice;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Objects;

public class LostProperty implements Comparable<LostProperty> {

    private String regNumber;
    private final String description;
    private final LocalDate date;

    public LostProperty(String regNumber, String description, LocalDate date) {
        this.regNumber = regNumber;
        this.description = description;
        this.date = date;
    }

    public LostProperty(String description, LocalDate date) {
        this.description = description;
        this.date = date;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public int compareTo(@NotNull LostProperty o) {
        if (description.equals(o.description)) return date.compareTo(o.date);
        return description.compareTo(o.description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LostProperty that)) return false;
        return Objects.equals(description, that.description) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, date);
    }
}
