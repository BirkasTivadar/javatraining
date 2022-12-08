/*
Hozz létre egy Member osztályt, String name, List<String> skills, Gender gender attribútumokkal!
*/

package lambdaoptional.club;

import java.util.ArrayList;
import java.util.List;

public record Member(String name, List<String> skills, Gender gender) {

    public Member(String name, List<String> skills, Gender gender) {
        this.name = name;
        this.skills = new ArrayList<>(skills);
        this.gender = gender;
    }

    @Override
    public List<String> skills() {
        return new ArrayList<>(skills);
    }
}
