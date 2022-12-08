/*
Hozz létre egy Car osztályt, amelynek attribútumai a következők: márka, típus, ár, hossz (méterben)!
*/

package lambdaintro.cars;

public record Car(String brand, String type, int price, double length) {
}
