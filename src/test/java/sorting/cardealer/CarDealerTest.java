package sorting.cardealer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarDealerTest {

    CarDealer carDealer;

    @BeforeEach
    void init() {
        carDealer = new CarDealer();
        carDealer.addCar(new Car("Ferrari", 2005, 9_000_000));
        carDealer.addCar(new Car("Trabant", 1983, 20_000));
        carDealer.addCar(new Car("Suzuki", 2020, 4_000_000));
        carDealer.addCar(new Car("Ford", 2015, 3_000_000));
        carDealer.addCar(new Car("Opel", 1999, 250_000));
    }

    @Test
    void testGetCarsOrderedByYearOfConstruction() {
        List<Car> expected = carDealer.getCarsOrderedByYearOfConstruction();

        assertEquals("Trabant", expected.get(0).brand());
        assertEquals("Ferrari", expected.get(2).brand());
        assertEquals("Suzuki", expected.get(4).brand());
    }

    @Test
    void testGetCarsOrderedByPrice() {
        List<Car> expected = carDealer.getCarsOrderedByPrice();

        assertEquals("Trabant", expected.get(0).brand());
        assertEquals("Ford", expected.get(2).brand());
        assertEquals("Ferrari", expected.get(4).brand());
    }
}