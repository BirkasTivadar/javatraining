/*
Találkozó
        Fontos találkozó előtt állunk, és nem akarjuk lekésni, ezért tudnunk kell, hány perc van addig. Azzal is számolunk, hogy az időpont módosulhat. Egy Rendezvous osztályt készítünk a funkciókhoz.
        Hibakezelés
        Üres pattern esetén dobjon IllegalArgumentException-t. Hasonlóképpen a sikertelen parse-olás is dobjon IllegalArgumentException-t. Ha elfeledkezünk az időpontról és már késő elmenni, a countMinutesLeft() metódus dobjon MissedOpportunityException-t. Ezt nekünk kell megírni, ez is egy RuntimeException.
        Tippek
        Használd a ChronoUnit enumot arra, hogy kiszámold, hány perc van két idő között! Szervezzük külön metódusba a paraméterek ellenőrzését!
        [rating feedback=java-datenewtypes-talalkozo]
*/

package datenewtypes.rendezvous;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Rendezvous {

    private LocalTime timeOfRendezvous;

    public Rendezvous(String timeString, String pattern) {
        if (isEmpty(pattern)) throw new IllegalArgumentException("Empty pattern string!");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        try {
            this.timeOfRendezvous = LocalTime.parse(timeString, formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Illegal time string: " + timeString);
        }
    }

    public Rendezvous(int hours, int minutes) {
        this.timeOfRendezvous = LocalTime.of(hours, minutes);
    }

    public String toString(String pattern) {
        if (isEmpty(pattern)) throw new IllegalArgumentException("Empty pattern string!");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return timeOfRendezvous.format(formatter);
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

    public long countMinutesLeft(LocalTime base) {
        if (timeOfRendezvous.isBefore(base)) throw new MissedOpportunityException("Too late!");
        return ChronoUnit.MINUTES.between(base, timeOfRendezvous);
    }

    public void pushLater(int hours, int minutes) {
        timeOfRendezvous = timeOfRendezvous.plusHours(hours).plusMinutes(minutes);
    }

    public void pullEarlier(int hours, int minutes) {
        timeOfRendezvous = timeOfRendezvous.minusHours(hours).minusMinutes(minutes);
    }
}
