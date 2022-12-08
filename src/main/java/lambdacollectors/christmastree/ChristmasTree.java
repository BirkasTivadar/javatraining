/*
Hozz létre egy christmastree.ChristmasTree osztályt, melynek attribútumai legyenek a következők: PineTreeType type, double height!
*/

package lambdacollectors.christmastree;

public record ChristmasTree(PineTreeType type, double height) {
    public double price() {
        return height * type().getPricePerMeter();
    }
}
