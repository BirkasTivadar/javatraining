/*
Iskolások
    Készíts egy schoolchild.PrimarySchoolChild nevű interfészt és két osztályt, amely ezt az interfészt implementálja: LowerClassSchoolChild és UpperClassSchoolChild! Mindkét osztálynak legyen két attribútuma: String name és int age, és legyen ezekhez getter és setter metódus! Legyen többféle paraméterezésű konstruktor is mindkét osztályban!
        Ezután készíts az interfészbe egy static PrimarySchoolChild of(int age) metódust, amelynek visszatérési értéke:
        egy újonnan példányosított LowerClassSchoolChild objektum, ha a paraméterként kapott életkor adat 6 és 10 között van,
        egy újonnan példányosított UpperClassSchoolChild objektum, ha a paraméterként kapott életkor adat 11 és 14 között van,
        minden egyéb esetben pedig dobjon a metódus IllegalArgumentException kivételt a megfelelő üzenettel!
*/

package interfacestaticmethods.schoolchild;

public interface PrimarySchoolChild {

    static PrimarySchoolChild of(int age) {
        if (age >= 6 && age <= 10) return new LowerClassSchoolChild(age);

        if (age >= 11 && age <= 14) return new UpperClassSchoolChild(age);

        throw new IllegalArgumentException("It's not a schoolchild with this age!");
    }
}
