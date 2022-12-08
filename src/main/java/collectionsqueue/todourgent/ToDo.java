/*
Hozz létre egy ToDo osztályt két attribútummal: String description és boolean isUrgent! Írd felül az osztály toString() metódusát is!
*/

package collectionsqueue.todourgent;

public record ToDo(String description, boolean isUrgent) {

    @Override
    public String toString() {
        return "ToDo{" +
                "description='" + description + '\'' +
                ", isUrgent=" + isUrgent +
                '}';
    }
}
