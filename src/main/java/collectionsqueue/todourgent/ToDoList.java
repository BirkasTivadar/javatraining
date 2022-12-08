/*
Sürgős tennivalók
        Hozz létre egy ToDo osztályt két attribútummal: String description és boolean isUrgent! Írd felül az osztály toString() metódusát is! Majd hozz létre egy ToDoList osztályt, melynek legyen egy List<ToDo> todos attribútuma! Legyen az osztályban egy Deque<ToDo> getTodosInUrgencyOrder() nevű metódus, amely szétválogatja a tennivaló listát úgy, hogy a sürgős tennivalókat (ahol az isUrgent attribútum értéke true) a visszaadandó ArrayDeque elejére teszi, a nem sürgőseket pedig a végére! Az osztály main() metódusában hozz létre néhány ToDo-t, hívd meg a getTodosInUrgencyOrder() metódust és írd ki a konzolra a visszakapott értéket! Majd hívd meg a visszakapott ArrayDeque pop() metódusát és írd ki a konzolra, melyik elemet veszi ki először!
*/

package collectionsqueue.todourgent;

import java.util.*;
import java.util.stream.Collectors;

public class ToDoList {

    private final List<ToDo> todos;

    public ToDoList(List<ToDo> toDos) {
        this.todos = new ArrayList<>(toDos);
    }

    Deque<ToDo> getTodosInUrgencyOrder() {
        return todos.stream()
                .sorted(Comparator.comparing(ToDo::isUrgent).reversed())
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    public static void main(String[] args) {
        List<ToDo> todos = List.of(
                new ToDo("washing", true),
                new ToDo("coche washing", false),
                new ToDo("cooking", false),
                new ToDo("making some sandwich", true),
                new ToDo("ironing", false),
                new ToDo("working", true)
        );

        ToDoList toDoList = new ToDoList(todos);

        Deque<ToDo> toDos = toDoList.getTodosInUrgencyOrder();

        System.out.println(toDos);
        System.out.println(toDos.pop());
    }
}
