package com.thoughtworks.tdd;

import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;

public class SmartParkingBoy extends ParkingBoy{
    @Override
    public Ticket parkCarThenReturnTicket(Car car) throws Exception {
        if (isParkingLotAvailable() && isCarEligible(car)) {
            Ticket ticket = new Ticket();
            parkingLots.stream().sorted(Comparator.comparing(ParkingLot::getOccupation))
                    .collect(Collectors.toList()).get(0)
                    .getLot().put(ticket, car);
            return ticket;
        } else {
            throw new Exception();
        }
    }
}
