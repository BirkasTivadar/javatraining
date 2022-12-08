/*
A talents.txt tartalmazza az indulók listáját, míg a votes.txt a leadott szavazatokat, azaz az előadó kódját.
*/

package ioprintwriter.talentshow;

public class Vote {

    private final int id;

    private int number;

    public Vote(int id, int number) {
        this.id = id;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public void incNum() {
        number++;
    }
}
