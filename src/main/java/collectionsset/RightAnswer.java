/*
Hozz létre egy RightAnswer osztályt, melynek egyetlen attribútuma a megfejtő neve! Definiáld felül az osztályban az equals() metódust, hogy két ugyanolyan névvel beküldött helyes megfejtést egyformának tekintsen! Emellett természetesen a hashCode() metódus is legyen felülírva! Ezután legyen egy QuestionGame osztály, amelynek legyen egy List<RightAnswer> típusú attribútuma, amelyben a beküldött helyes megfejtések találhatók! Ezután írj az osztályba egy Set<String> drawWinners() nevű metódust, amely a helyes megfejtések közül kisorsol és egy HashSet-ben visszaad 5 nyertes nevet! Figyelj arra, hogy a listában ugyanannak az embernek a megfejtései többször is szerepelhetnek, de sorsolni addig kell, amíg öt különböző nevet nem kapsz! Akit már kisorsoltál, azt töröld is sorsolás közben a listából! Ha a lista hamarabb kiürülne, mint ahogy összegyűlne az öt név, vagyis ha túl kevés megfejtés érkezett be, dobjon a metódus IllegalArgumentException-t!
*/

package collectionsset;

import java.util.Objects;

public record RightAnswer(String name) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RightAnswer that)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
