/*
A PermitPlan osztály a SketchPlan leszármazottja legyen és implementálja a Header interfészt is! Legyen két attribútuma: protected String nameOfClient és protected String addressOfBuilding! Valósítsa meg az interfész két metódusát (adja vissza az attribútumok értékét, amelyet a konstruktor állítson be)! Ezenkívül tartalmazzon egy String getHeader() metódust, amely szövegesen adja vissza a tervdokumentáció címét, az építtető nevét és az építési helyszín címét is!
*/

package polymorphism.architect;

public class PermitPlan extends SketchPlan implements Header {

    private final String nameOfClient;
    protected String addressOfBuilding;

    public PermitPlan(int pagesOfDocumentation, String title, String nameOfClient, String addressOfBuilding) {
        super(pagesOfDocumentation, title);
        this.nameOfClient = nameOfClient;
        this.addressOfBuilding = addressOfBuilding;
    }

    @Override
    public String getNameOfClient() {
        return nameOfClient;
    }

    @Override
    public String getAddressOfBuilding() {
        return addressOfBuilding;
    }

    public String getHeader() {
        return String.format("%s, %s", nameOfClient, addressOfBuilding);
    }
}
