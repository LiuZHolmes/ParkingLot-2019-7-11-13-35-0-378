package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class parkingTest {
    @Test
    public void should_return_same_car_when_park_a_car_and_fetch_it_back_with_ticket() throws Exception {
        // given
        Car originalCar = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        // when
        Ticket ticket = parkingBoy.parkCarThenReturnTicket(originalCar);
        Car fetchedCar = parkingBoy.fetchCarByTicket(ticket);
        // then
        assertEquals(originalCar, fetchedCar);
    }


    @Test
    public void should_return_same_cars_when_park_cars_and_fetch_them_back_with_tickets() throws Exception {
        // given
        Car firstOriginalCar = new Car();
        Car secondOriginalCar = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        // when
        Ticket firstTicket = parkingBoy.parkCarThenReturnTicket(firstOriginalCar);
        Ticket secondTicket = parkingBoy.parkCarThenReturnTicket(secondOriginalCar);
        Car firstFetchedCar = parkingBoy.fetchCarByTicket(firstTicket);
        Car secondFetchedCar = parkingBoy.fetchCarByTicket(secondTicket);
        // then
        assertEquals(firstOriginalCar, firstFetchedCar);
        assertEquals(secondOriginalCar, secondFetchedCar);
    }


    @Test
    public void should_throw_exception_when_given_a_wrong_ticket() throws Exception {
        // given
        Car originalCar = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();

        // then
        assertThrows(Exception.class, () -> {
            // when
            Ticket ticket = new Ticket();
            parkingBoy.fetchCarByTicket(ticket);
        });
    }

    @Test
    public void should_throw_exception_when_given_a_fetched_ticket() throws Exception {
        // given
        Car originalCar = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        // when
        Ticket ticket = parkingBoy.parkCarThenReturnTicket(originalCar);
        parkingBoy.fetchCarByTicket(ticket);

        // then
        assertThrows(Exception.class, () -> {
            // when
            parkingBoy.fetchCarByTicket(ticket);
        });
    }

    @Test
    public void should_throw_exception_when_park_a_car_to_full_parking_lot() throws Exception {
        // given
        ParkingBoy parkingBoy = new ParkingBoy();
        // when

        // then
        assertThrows(Exception.class, () -> {
            // when
            while (true) {
                parkingBoy.parkCarThenReturnTicket(new Car());
            }
        });
    }

    @Test
    public void should_throw_exception_when_park_a_parked_car() throws Exception {
        // given
        Car originalCar = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.parkCarThenReturnTicket(originalCar);
        // when

        // then
        assertThrows(Exception.class, () -> {
            // when
            parkingBoy.parkCarThenReturnTicket(originalCar);

        });
    }
}
