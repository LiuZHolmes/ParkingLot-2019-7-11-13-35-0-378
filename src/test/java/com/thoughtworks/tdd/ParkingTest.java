package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingTest {
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
    public void should_throw_exception_show_error_message_when_given_a_wrong_ticket() throws Exception {
        // given
        Car originalCar = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();

        // then
        Exception exception = assertThrows(Exception.class, () -> {
            // when
            Ticket ticket = new Ticket();
            parkingBoy.fetchCarByTicket(ticket);
        });
        assertEquals("Unrecognized parking ticket",exception.getMessage());
    }

    @Test
    public void should_throw_exception_show_error_message_when_not_given_ticket() throws Exception {
        // given
        Car originalCar = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();

        // then
        Exception exception = assertThrows(Exception.class, () -> {
            // when
            Ticket ticket = new Ticket();
            parkingBoy.fetchCarByTicket();
        });
        assertEquals("Please provide your parking ticket",exception.getMessage());
    }


    @Test
    public void should_throw_exception_when_given_a_used_ticket() throws Exception {
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
    public void should_throw_exception_and_show_message_when_park_a_car_to_full_parking_lot() throws Exception {
        // given
        ParkingBoy parkingBoy = new ParkingBoy();

        // then
        Exception exception = assertThrows(Exception.class, () -> {
            // when
            while (true) {
                parkingBoy.parkCarThenReturnTicket(new Car());
            }
        });
        assertEquals("Not enough position",exception.getMessage());
    }

    @Test
    public void should_throw_exception_when_park_a_parked_car() throws Exception {
        // given
        Car originalCar = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.parkCarThenReturnTicket(originalCar);

        // then
        assertThrows(Exception.class, () -> {
            // when
            parkingBoy.parkCarThenReturnTicket(originalCar);

        });
    }

    @Test
    public void should_throw_exception_when_park_a_null_car() throws Exception {
        // given
        final Car nullCar = null;
        ParkingBoy parkingBoy = new ParkingBoy();

        // then
        assertThrows(Exception.class, () -> {
            // when
            parkingBoy.parkCarThenReturnTicket(nullCar);

        });
    }

    @Test
    public void should_park_a_car_to_second_slot_when_first_slot_is_full_and_park_a_car() throws Exception {
        // given
        Car originalCar = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        while (parkingBoy.isParkingLotAvailableAt(0)) {
            parkingBoy.parkCarThenReturnTicket(new Car());
        }
        // when
        Ticket ticket = parkingBoy.parkCarThenReturnTicket(originalCar);
        Car fetchedCar = parkingBoy.fetchCarByTicket(ticket);
        // then
        assertEquals(originalCar, fetchedCar);
    }

    @Test
    public void should_park_a_car_to_parking_lot_that_is_more_positions_when_smart_parking_boy_park_a_car() throws Exception {
        // given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        // when
        smartParkingBoy.parkCarThenReturnTicket(new Car());
        smartParkingBoy.parkCarThenReturnTicket(new Car());
        // then
        List<Integer> occupation = smartParkingBoy.getOccupationOfParkingLots();
        assertEquals(occupation.get(0),occupation.get(1));
    }

    @Test
    public void should_park_a_car_to_parking_lot_that_has_larger_available_position_rate_when_super_smart_parking_boy_park_a_car() throws Exception {
        // given
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        // when
        superSmartParkingBoy.parkCarThenReturnTicket(new Car());
        superSmartParkingBoy.parkCarThenReturnTicket(new Car());
        // then
        List<Integer> occupation = superSmartParkingBoy.getOccupationOfParkingLots();
        assertEquals(occupation.get(0),occupation.get(1));
    }

    @Test
    public void should_add_parking_boy_to_management_list_when_manager_do_so() {
        // given
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager();
        ParkingBoy parkingBoy = new ParkingBoy();
        // when
        parkingLotServiceManager.addToManagementList(parkingBoy);
        // then
        assertEquals(true,parkingLotServiceManager.doesParkingBoyInManagementList(parkingBoy));
    }
}
