/*
Készíts egy Equator nevű osztályt, amely static final módosítószókkal ellátott attribútumokban tárolja az Egyenlítő nevét és hosszát, valamint impementálja a Name és a Length interfészeket! Valósítsd meg megfelelő módon a két interfész metódusait!
*/

package interfacerules.commonproperties;

public class Equator implements Name, Length {

    private static final String NAME = "Equator";
    private static final double LENGTH = 40_075.0;

    @Override
    public double length() {
        return LENGTH;
    }

    @Override
    public String name() {
        return NAME;
    }
}
