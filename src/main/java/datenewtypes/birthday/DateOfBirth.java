/*
Születésnap
        Életünk nevezetes dátumairól (DateOfBirth osztály) szeretnénk speciális információkat kapni, mint például: a hét mely napján születtünk, eddig összesen hány napot éltünk, vagy a saját és barátunk/párunk születése között pontosan hány nap telt el. A dátumokat tetszőlegesen formázott String formájában is szeretnénk látni.
*/


package datenewtypes.birthday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateOfBirth {

    private final LocalDate dateOfBirth;

    public DateOfBirth(int year, int month, int day) {
        this.dateOfBirth = LocalDate.of(year, month, day);
    }

    public DateOfBirth(String dateString, String pattern) {
        this(dateString, pattern, Locale.ENGLISH);
    }

    public DateOfBirth(String dateOfBirthString, String pattern, Locale locale) {
        if (isEmpty(pattern)) throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        if (locale == null) throw new NullPointerException("Locale must not be null!");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, locale);

        this.dateOfBirth = LocalDate.parse(dateOfBirthString, formatter);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

    public String toString(String pattern) {
        if (isEmpty(pattern)) throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateOfBirth.format(formatter);
    }

    public String findDayOfWeekForBirthDate(Locale locale, LocalDate date) {
        if (locale == null) throw new NullPointerException("Locale must not be null!");
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.getDisplayName(TextStyle.FULL, locale);
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        return this.findDayOfWeekForBirthDate(locale, dateOfBirth);
    }


    public long countDaysSinceBirth(LocalDate now) {
        if (dateOfBirth.isAfter(now)) throw new IllegalStateException("Birthdate is in the future!");
        return ChronoUnit.DAYS.between(dateOfBirth, now);
    }

    public long countDaysBetween(DateOfBirth other) {
        return ChronoUnit.DAYS.between(dateOfBirth, other.getDateOfBirth());
    }
}
