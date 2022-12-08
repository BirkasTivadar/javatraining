/*
Felvételi vizsga eredmények
        Készíts egy ExamResult osztályt, amely egy felvételi vizsgán részt vevő személy eredményét tárolja! Két attribútuma a felvételiző neve és az eredménye (pontszám formájában). Majd készítsd el az Exam osztályt, amelynek List<ExamResult> attribútuma tárolja a felvételi eredményeket! A lista értékét konstruktorban kapja meg! Legyen egy List<String> getNamesOfSucceededPeople(int places), amely visszaadja azok listáját, akik felvételt nyertek (a places paraméter mondja meg, hogy hány helyre vesznek föl embereket)! A listában a felvett emberek neve az eredményeik szerinti sorrendben szerepeljen, tehát legelöl legyen a legtöbb pontot elért ember neve! Kezeld a metódusban azt is, ha a felvételi helyek száma több, mint ahányan egyáltalán jelentkeztek!
*/

package collectionsclass;

import java.util.ArrayList;
import java.util.List;

public class Exam {

    private final List<ExamResult> exams;

    public Exam(List<ExamResult> exams) {
        this.exams = new ArrayList<>(exams);
    }

    public List<String> getNamesOfSucceededPeople(int places) {
        exams.sort((e1, e2) -> e2.points() - e1.points());
        if (places >= exams.size()) return exams.stream().map(ExamResult::name).toList();
        return exams.stream().limit(places).map(ExamResult::name).toList();
    }
}
