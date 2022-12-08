/*
Legyen egy ConstructionPlan osztály, amelynek van egy private int sheetsOfConstructionDrawings attribútuma, az osztály konstruktorában beállítva, valamint getter is legyen ehhez az attribútumhoz! Az osztály legyen a PermitPlan leszármazottja!
*/

package polymorphism.architect;

public class ConstructionPlan extends PermitPlan {

    private final int sheetsOfConstructionDrawings;

    public ConstructionPlan(int pagesOfDocumentation, String title, String nameOfClient, String addressOfBuilding, int sheetsOfConstructionDrawings) {
        super(pagesOfDocumentation, title, nameOfClient, addressOfBuilding);
        this.sheetsOfConstructionDrawings = sheetsOfConstructionDrawings;
    }

    public int getSheetsOfConstructionDrawings() {
        return sheetsOfConstructionDrawings;
    }
}
