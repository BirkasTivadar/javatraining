/*
Készíts egy schoolchild.PrimarySchoolChild nevű interfészt és két osztályt, amely ezt az interfészt implementálja: LowerClassSchoolChild és UpperClassSchoolChild! Mindkét osztálynak legyen két attribútuma: String name és int age, és legyen ezekhez getter és setter metódus! Legyen többféle paraméterezésű konstruktor is mindkét osztályban!
*/

package interfacestaticmethods.schoolchild;

public class LowerClassSchoolChild implements PrimarySchoolChild {

    private String name;

    private int age;

    public LowerClassSchoolChild(String name) {
        this.name = name;
    }

    public LowerClassSchoolChild(int age) {
        this.age = age;
    }

    public LowerClassSchoolChild(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
