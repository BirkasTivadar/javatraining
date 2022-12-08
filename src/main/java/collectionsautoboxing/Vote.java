/*
Név szerinti szavazás
        Az országgyűlés egy fontos törvényjavaslatot készül megszavazni név szerinti szavazással. Készíts ehhez először egy VoteResult nevű enumot, amelyben három érték legyen: YES, NO és ABSTAIN (tartózkodik)! Legyen ezután egy Vote osztály, amelyben legyen egy Map<VoteResult, Integer> getResult(Map<String, VoteResult>) metódus! Ez a metódus megkapja a szavazás személyenkénti eredményét egy Map-ben, valahogy így:
        "John Doe" - YES
        "Jack Doe" - NO
        "Jill Doe" - YES
        A metódus visszatérési értéke pedig egy olyan Map legyen, amelyben benne van, hogy hányan szavaztak igennel, hányan nemmel és hányan tartózkodtak, vagyis például így:
        YES - 87
        NO - 34
        ABSTAIN - 23
*/

package collectionsautoboxing;

import java.util.HashMap;
import java.util.Map;

public class Vote {

    public Map<VoteResult, Integer> getResult(Map<String, VoteResult> votes) {
        Map<VoteResult, Integer> result = new HashMap<>();
        int yes = 0;
        int no = 0;
        int abstain = 0;
        for (VoteResult vr : votes.values()) {
            if (vr == VoteResult.YES) yes++;
            if (vr == VoteResult.NO) no++;
            if (vr == VoteResult.ABSTAIN) abstain++;
        }
        result.put(VoteResult.YES, yes);
        result.put(VoteResult.NO, no);
        result.put(VoteResult.ABSTAIN, abstain);

        return result;
    }
}
