package interfacedefaultmethods.seats;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeatTest {

    @Test
    void testFamilyCar() {
        FamilyCar familyCar = new FamilyCar();

        assertEquals(5, familyCar.numberOfSeats());
    }

    @Test
    void testSportsCar() {
        SportsCar sportsCar = new SportsCar();

        assertEquals(2, sportsCar.numberOfSeats());
    }

    @Test
    void testCar() {
        Car car = new Car("Fiat Scudo", 8);

        assertEquals("Fiat Scudo", car.brand());
        assertEquals(8, car.numberOfSeats());
    }
}