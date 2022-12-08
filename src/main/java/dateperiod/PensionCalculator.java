/*
Nyugdíj
        Nyugdíjszámításhoz szükségünk van egy olyan osztályra, amely segítségével összegezni tudjuk a nyugdíj jogosultságot adó időtartamokat, egy-egy dátum adta intervallumot módosítani tudunk (pl. jogosultságot nem szerző napokkal), és egyéb műveleteket is végezhetünk.
        Hibakezelés
        A Stringként megadott paraméterek nem lehetnek null vagy üres String értékek. Ezek esetében dobjon a rendszer IllegalArgumentException-t, a megfelelő tájékoztató szöveggel. A dátum paraméter nem lehet null érték, a megfelelő metódus dobjon NullPointerException-t.
        Megvalósítási javaslatok
        A Period objektum normalizálható, de ez csak az év és hónap mezők “átváltását” biztosítja. Készítsünk egy teljes mértékben normalizáló metódust, ami a nap és hónap értékek közötti konverziót is biztosítja 1 hónap = 30 nap átváltás mellett (Period fullyNormalized(Period period)).
        publikus metódusok:
            public void addEmploymentPeriod(Period period)
            public Period sumEmploymentPeriods()
            public Period modifyByDays(Period period, int days)
            public Period getPeriodBetweenDates(LocalDate fromDate, LocalDate toDate)
            public Period getPeriodBetweenDates(String fromDate, String toDate, String pattern)
            public int calculateTotalDays(Period period)
        Tippek
        Ahol a visszatérési érték Period, mindig a teljes mértékben normalizált objektumot adjuk vissza! (Ennek létjogosultsága persze vitatható, de legyünk következetesek!) Nézzük át a dokumentációban a parszolható period String szerkezetét! A paraméter stringek vizsgálatához készítsünk egy boolean isEmpty(String str) metódust! Az összegyűjtött időtartamokat egy kollekcióban célszerű tárolni, és azt lehet szükség esetén összegezni.
*/

package dateperiod;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static java.time.Period.between;
import static java.time.Period.of;

public class PensionCalculator {

    private Period workPeriod;

    public PensionCalculator() {
        workPeriod = Period.ZERO;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

    public void addEmploymentPeriod(Period period) {
        workPeriod = workPeriod.plus(period);
    }

    private Period fullyNormalized(Period period) {
        int days = period.getDays();
        if (days > 30) {
            int months = days / 30;
            period = period.plusMonths(months);
            days %= 30;
        }
        Period result = Period.of(period.getYears(), period.getMonths(), days);
        return result.normalized();
    }

    public Period sumEmploymentPeriods() {
        return fullyNormalized(of(workPeriod.getYears(), workPeriod.getMonths(), workPeriod.getDays()));
    }

    public int calculateTotalDays(Period period) {
        return period.getYears() * 365 + period.getMonths() * 30 + period.getDays();
    }

    public Period modifyByDays(Period period, int plusDays) {
        return period.plusDays(plusDays);
    }

    public Period getPeriodBetweenDates(LocalDate start, LocalDate end) {
        if (start == null || end == null) throw new NullPointerException("Null parameters are not allowed!");
        return between(start, end);
    }

    public Period getPeriodBetweenDates(String from, String to, String pattern) {
        if (isEmpty(from)) throw new IllegalArgumentException("Empty from date string, cannot use: ");
        if (isEmpty(to)) throw new IllegalArgumentException("Empty to date string, cannot use: ");
        if (isEmpty(pattern)) throw new IllegalArgumentException("Empty pattern string, cannot use: ");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate start = LocalDate.parse(from, formatter);
        LocalDate end = LocalDate.parse(to, formatter);

        return between(start, end);
    }
}
