package datenewtypes.familybirthdays;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.List;

public class FamilyBirthdays {

    private final List<LocalDate> birthdays;

    public FamilyBirthdays(LocalDate... birthdays) {
        this.birthdays = Arrays.asList(birthdays);
    }

    public boolean isFamilyBirthday(TemporalAccessor date) {
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);
        return birthdays.stream()
                .anyMatch(b -> b.getMonthValue() == month && b.getDayOfMonth() == day);
    }

    public long nextFamilyBirthDay(TemporalAccessor date) {
        int year = date.get(ChronoField.YEAR);
        birthdays.replaceAll(b -> LocalDate.of(year, b.getMonthValue(), b.getDayOfMonth()));
        boolean isBefore = isBefore(date);

        if (isBefore) return getDaysIsBefore(date);
        else {
            birthdays.replaceAll(b -> b.plusYears(1));
            return getDaysIsAfter(date);
        }
    }

    private boolean isBefore(TemporalAccessor date) {
        return birthdays.stream()
                .anyMatch(b -> LocalDate.from(date).isBefore(b) || b.equals(LocalDate.from(date)));
    }

    private long getDaysIsAfter(TemporalAccessor date) {
        return birthdays.stream()
                .mapToLong(b -> ChronoUnit.DAYS.between(LocalDate.from(date), b))
                .min().getAsLong();
    }

    private long getDaysIsBefore(TemporalAccessor date) {
        return birthdays.stream()
                .mapToLong(b -> ChronoUnit.DAYS.between(LocalDate.from(date), b))
                .filter(n -> n >= 0)
                .min().getAsLong();
    }
}
