/*
Hegycsúcsok
        Készíts egy Peak nevű osztályt két attribútummal: a hegycsúcs neve és magassága! Majd készíts egy Mountain nevű osztályt, melynek van egy olyan tömb attribútuma, amely csak a csúcsok magasságait tartalmazza, növekvő sorrendben! Legyen az osztályban egy boolean searchPeak(Peak peak) metódus, amely bináris kereséssel megkeresi, hogy a paraméterül átadott hegycsúcs magassága benne van-e a tömbben!
*/

package searching.peaks;

import java.util.Arrays;

public class Mountain {

    private final int[] heights;

    public Mountain(int[] heights) {
        this.heights = heights;
    }

    public boolean searchPeak(Peak peak) {
        return Arrays.binarySearch(heights, peak.height()) > -1;
    }
}
