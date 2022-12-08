/*
Ennek modellezésére hozd létre a Course osztályt, amelynek attribútumai a tanfolyam neve, ára és a szintje!
*/

package optional.training;

public record Course(String name, Level level, int price) {
}
