package com.thoughtworks.tdd;

import java.util.Comparator;
import java.util.stream.Collectors;

public class SuperSmartParkingBoy extends ParkingBoy {
    @Override
    public Ticket parkCar(Car car) {
        Ticket ticket = new Ticket();
        parkingLots.stream().sorted(Comparator.comparing(ParkingLot::getAvailablePositionRate).reversed())
                .collect(Collectors.toList()).get(0)
                .getLot().put(ticket, car);
        return ticket;
    }
}

