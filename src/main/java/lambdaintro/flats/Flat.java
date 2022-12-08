/*
Hozz létre egy Flat osztályt, amelynek attribútumai a következők: cím, terület (négyzetméterben), ár (forintban)!
*/

package lambdaintro.flats;

public record Flat(String address, double area, int price) {
}
