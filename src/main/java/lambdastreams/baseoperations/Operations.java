/*
Alapműveletek
        Készíts egy baseoperations.Operations osztályt, amely egész számokból álló listát tárol! A listát a konstruktoron át kapja meg. Készíts metódusokat az alábbi számítások elvégzésére:
        Optional<Integer> min(): a metódus adja vissza a legkisebb számot!
        Integer sum(): a metódus adja vissza az elemek összegét!
        boolean isAllPositive(): megvizsgálja, hogy minden elem pozitív-e.
        Set<Integer> getDistinctElements(): az összes különböző elemet pontosan egyszer tartalmazó kollekció.
        Az összes metódus kizárólag stream műveleteket használjon!
*/

package lambdastreams.baseoperations;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public record Operations(List<Integer> numbers) {

    public Optional<Integer> min() {
        return numbers.stream()
                .min(Integer::compareTo);
    }

    public int sum() {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    public Set<Integer> getDistinctElements() {
        return numbers.stream()
                .collect(Collectors.toSet());
    }

    public boolean isAllPositive() {
        return numbers.stream()
                .allMatch(n -> n > 0);
    }
}
