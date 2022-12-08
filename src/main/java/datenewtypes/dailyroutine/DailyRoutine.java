/*
Gyakorlati feladat 2
        Phileas Fogg egy rendkívül precíz angol gentleman, aki a napjait percnyi pontossággal osztja be. Nyelvtanára sajnos nem ennyire pontos, minden délelőtt 9 óra körül kezdi az órákat, és három 45 perces nyelvórát tart egy 25 perces szünettel.
        Fogg úr percre pontosan szeretné tudni, hogy mikor fogják befejezni, és azt is, hogy be fogják-e fejezni déli 12 előtt az órákat. Segítsünk neki ebben!
        Egy olyan osztályt - DailyRoutine - hozzunk létre, amelynek objektuma tárolja a mindenkori órakezdetet percnyi pontossággal, és ki tudja számolni, mikor fejeződik be az oktatás, valamint azt is meg tudja mondani, hogy ez még déli 12 óra előtt megtörténik-e.
        Az osztály startTime attribútuma tárolja a nyelvórák kezdetét, ez megadható óra és perc, de megadható standard szöveges formában is (hh:mm).
        Megvalósítás
        Az osztály objektumait többféle módon is létre lehessen hozni, számokkal vagy akár szöveges dátum formátumból. Publikus metódusai segítségével a tárolt időpont módosítható a befejezés időpontjára, és lekérdezhető, hogy ez az időpont hogyan viszonyul a déli 12 órához, azt megelőzi-e.
        publikus metódusok:
            public DailyRoutine(int hour, int minute)
            public DailyRoutine(String timeString)

            public void setFutureTime(int minutes)
            public boolean isBeforeNoon()
        Tippek
        Érdemes utánanézni a LocalTime osztály leírásának a Java dokumentációban, és megismerkedni az osztály által biztosított LocalTime.NOON final static értékkel.
        [rating feedback=java-datenewtypes-dailyroutine]
*/

package datenewtypes.dailyroutine;

import java.time.LocalTime;

public class DailyRoutine {

    private LocalTime start;

    public DailyRoutine(int hour, int minute) {
        this.start = LocalTime.of(hour, minute);
    }

    public DailyRoutine(String timeString) {
        this.start = LocalTime.parse(timeString);
    }

    public LocalTime getStart() {
        return start;
    }

    public void setFutureTime(int minutes) {
        this.start = start.plusMinutes(minutes);
    }

    public boolean isBeforeNoon() {
        return start.isBefore(LocalTime.NOON);
    }
}
