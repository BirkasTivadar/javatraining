/*
Nyereményjáték
        Egy rádióban nyereményjátékot hirdetnek. A lényege az, hogy néhány napon keresztül minden nap elhangzik egy-egy kérdés, amelyre a helyes választ e-mailben lehet elküldeni. A játék végén a helyes beküldők nevei közül fognak sorsolni 5 nevet, akik egy utazáson vehetnek részt. Fontos, hogy a sorsolandó nevek között mindenkinek a neve annyiszor szerepel, ahány kérdésre helyesen válaszolt. Vagyis ugyanaz az ember szerepelhet többször is, így több esélye van nyerni, viszont a nyertesek közé csak egyszer kerülhet be a neve.
        Hozz létre egy RightAnswer osztályt, melynek egyetlen attribútuma a megfejtő neve! Definiáld felül az osztályban az equals() metódust, hogy két ugyanolyan névvel beküldött helyes megfejtést egyformának tekintsen! Emellett természetesen a hashCode() metódus is legyen felülírva! Ezután legyen egy QuestionGame osztály, amelynek legyen egy List<RightAnswer> típusú attribútuma, amelyben a beküldött helyes megfejtések találhatók! Ezután írj az osztályba egy Set<String> drawWinners() nevű metódust, amely a helyes megfejtések közül kisorsol és egy HashSet-ben visszaad 5 nyertes nevet! Figyelj arra, hogy a listában ugyanannak az embernek a megfejtései többször is szerepelhetnek, de sorsolni addig kell, amíg öt különböző nevet nem kapsz! Akit már kisorsoltál, azt töröld is sorsolás közben a listából! Ha a lista hamarabb kiürülne, mint ahogy összegyűlne az öt név, vagyis ha túl kevés megfejtés érkezett be, dobjon a metódus IllegalArgumentException-t!
*/

package collectionsset;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class QuestionGame {

    List<RightAnswer> rightAnswerList;

    public QuestionGame(List<RightAnswer> rightAnswerList) {
        this.rightAnswerList = rightAnswerList;
    }

    public Set<String> drawWinners() {
        Collections.shuffle(rightAnswerList);
        Set<String> winners = rightAnswerList.stream()
                .map(RightAnswer::name)
                .distinct()
                .limit(5)
                .collect(Collectors.toSet());
        if (winners.size() < 5) throw new IllegalArgumentException("Not enough right answers!");
        return winners;
    }
}
