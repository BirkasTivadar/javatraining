/*
Gyakorlati feladat
        Programozási munka során rögzíteni kívánjuk, hogy az egyes funkciók kidolgozására mennyi időt fordítottunk. Készítsünk egy WorkHoursCalculator osztályt, amely ezt megvalósítja, az egyes időtartamokat legyünk képesek többféleképpen is bevinni, a beviteleket a rendszer összegzi, és lekérdezhetjük Duration formájában, megjeleníthetjük String-ként valamint kiszámíthatjuk az összes ráfordított időt munkaórákban.
        Hibakezelés
        Parszolás esetén a String nem lehet üres. Ezt kivételkezeléssel biztosítsuk, null vagy üres String esetén dobjon IllegalArgumentException-t a megfelelő szöveggel. Hasonlóképpen, ha a String paraméter nem üres, de a parszolás mégsem hajtható végre, dobjon IllegalArgumentException-t a megfelelő szöveggel.
        Megvalósítási javaslatok
        A Duration objektum esetében a nap-óra-perc Stringgé alakításnál próbáljuk a Duration saját metódusait használni!
        publikus metódusok:
            public void addWorkTime(Duration duration)
            public void addWorkTime(int days, int hours, int minutes)
            public void addWorkTime(String durationString)
            public int calculateWorkHours()
            public Duration getWorkDuration()
            public String toString()
*/

package dateduration;

import java.time.Duration;

public class WorkHoursCalculator {

    private Duration workDuration;

    public WorkHoursCalculator() {
        workDuration = Duration.ZERO;
    }

    public void addWorkTime(Duration duration) {
        workDuration = workDuration.plus(duration);
    }

    public void addWorkTime(int days, int hours, int minutes) {
        Duration duration = Duration.ofDays(days);
        duration = duration.plusHours(hours);
        duration = duration.plusMinutes(minutes);

        workDuration = workDuration.plus(duration);
    }

    public void addWorkTime(String durationString) {
        if (isEmpty(durationString)) throw new IllegalArgumentException("Parameter must not be empty!");
        try {
            Duration duration = Duration.parse(durationString);
            workDuration = workDuration.plus(duration);
        } catch (Exception e) {
            throw new IllegalArgumentException("Parameter must match PnDTnHnM pattern, but found: " + durationString);
        }
    }

    public Duration getWorkDuration() {
        return workDuration;
    }
    public long calculateWorkHours() {
        return workDuration.toHours();
    }

    @Override
    public String toString() {
        return String.format("Days: %d, hours: %d, minutes: %d", workDuration.toDaysPart(), workDuration.toHoursPart(), workDuration.toMinutesPart());
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }


}
