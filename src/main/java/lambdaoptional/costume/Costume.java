/*
Hozz létre egy Costume osztályt, amelynek attribútumai a következők: leírás, méret (egy enum, S, M, L, XL felsorolókkal), ár (forintban)!
*/

package lambdaoptional.costume;

public record Costume(String description, Size size, int price) {
}
