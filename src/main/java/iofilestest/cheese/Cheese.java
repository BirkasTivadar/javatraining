/*
Készíts egy immutable Cheese osztályt, mely a sajt nevét (String) és laktóztartalmát (double) tartalmazza.
*/

package iofilestest.cheese;

public record Cheese(String name, double lactoseContent) {

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.name(), this.lactoseContent);
    }
}
