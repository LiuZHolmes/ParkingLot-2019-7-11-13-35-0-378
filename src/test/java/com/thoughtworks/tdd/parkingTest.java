package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        Assertions.assertEquals(originalCar,fetchedCar);
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
        Assertions.assertEquals(firstOriginalCar,firstFetchedCar);
        Assertions.assertEquals(secondOriginalCar,secondFetchedCar);
    }
}
