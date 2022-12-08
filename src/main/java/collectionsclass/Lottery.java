/*
Lottó
        Implementálj egy lottó gépet ahol megadható a lottó típusa (ötös, hatos, stb.) és az is, hogy hány számból válasszon (golyók száma). Írj egy Lottery osztályt, amely létrehozza a golyókat (List<Integer> értékek), összekeveri, majd megcsinálja a “húzást”, azaz kiválaszt a lottó típusának megfelelő számú golyót, majd a kihúzott számokat növekvő sorba rendezi és úgy adja vissza!
        A húzást a selectWinningNumbers(int lotteryType, int ballCount) metódus végzi, amely egy List<Integer>-ben adja vissza a nyerő számokat. (A visszaadott számok pozitív egész számok, és nem lehetnek nagyobbak, mint amennyi golyó van. A golyók számozása egytől kezdődik. Ugyanaz a szám nem szerepelhet kétszer, sem azok között, ahonnan húzunk, sem a visszaadottak között.)
        Ha a selectWinningNumbers(int lotteryType, int ballCount) metódust rossz paraméterekkel hívták meg (több vagy ugyanannyi számot kellene kihúzni, mint amennyit generál), a metódus dobjon egy IllegalArgumentException kivételt!
*/

package collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lottery {

    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        if (lotteryType >= ballCount)
            throw new IllegalArgumentException("There must be more balls than the winning numbers!");
        List<Integer> lotteryNumbers = new ArrayList<>(IntStream.range(1, ballCount + 1).boxed().toList());
        Collections.shuffle(lotteryNumbers);
        return lotteryNumbers.stream()
                .limit(lotteryType)
                .sorted()
                .toList();
    }
}
