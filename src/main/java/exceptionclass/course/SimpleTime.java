/*
Időpont
    Készíts egy course.SimpleTime osztályt, amely egy egyszerűsített időpont reprezentáló osztály! (Ehhez az osztályhoz hasonló módon van implementálva a standard Java osztálykönyvtárban található LocalTime osztály is.)
        Lehet létrehozni óra és perc megadásával és lehet időpontot megadni “hh:mm” alakú Stringgel is!
        Legyen felüldefiniálva a toString úgy, hogy “hh:mm” alakú időt adjon!
        Legyen getHour, és getMinute metódusa is!
        Hibakezelés:
        Definiálj egy saját InvalidTimeException-t, amely RuntimeException leszármazott. Dobjon InvalidTimeException-t “Hour is invalid (0-23)” szöveggel, ha a konstruktornak nem megfelelő óra értéket adnak meg. Dobjon InvalidTimeException-t “Minute is invalid (0-59)” szöveggel ha a perc hibás. Dobjon InvalidTimeException-t “Time is null” szöveggel ha null String-et adnak meg. Dobjon InvalidTimeException-t “Time is not hh:mm”, ha érvénytelen a String formátuma.
        Készíts egy Course osztályt! A kurzusnak van neve (name) és kezdete (begin), ami SimpleTime típusú. Legyen konstruktora, ahol megkapja az adatokat, legyenek getterei, valamint legyen felüldefiniálva a toString-je úgy, hogy hh:mm: kurzusnév alakú legyen.
*/

package exceptionclass.course;

public class SimpleTime {

    private int hour;

    private int minute;

    public SimpleTime(int hour, int minute) {
        setTime(hour, minute);
    }

    public SimpleTime(String time) {
        if (time == null) throw new InvalidTimeException("Time is null");
        int hour;
        int minute;
        try {
            String[] timeArr = time.split(":");
            hour = Integer.parseInt(timeArr[0]);
            minute = Integer.parseInt(timeArr[1]);
        } catch (RuntimeException rte) {
            throw new InvalidTimeException("Time is not hh:mm");
        }
        setTime(hour, minute);
    }

    private void setTime(int hour, int minute) {
        if (hour < 0 || hour > 23) throw new InvalidTimeException("Hour is invalid (0-23)");
        if (minute < 0 || minute > 59) throw new InvalidTimeException("Minute is invalid (0-59)");
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", this.hour, this.minute);
    }
}
