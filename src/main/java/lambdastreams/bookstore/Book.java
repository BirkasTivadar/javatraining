/*
Készíts egy bookstore.Book osztályt a könyv címével, kiadási évével, árával, darabszámával! A konstruktor is ebben a sorrendben kapja meg az adatokat!
*/

package lambdastreams.bookstore;

public record Book(String title, int yearOfPublish, int price, int pieces) {
}
