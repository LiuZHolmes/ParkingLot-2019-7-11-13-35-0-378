package com.thoughtworks.tdd;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy() {
        parkingLot = new ParkingLot();
    }

    public Ticket parkCarThenReturnTicket(Car car) {
        Ticket ticket = new Ticket();
        parkingLot.getLot().put(ticket,car);
        return ticket;
    }

    public Car fetchCarByTicket(Ticket ticket) throws Exception {
        if (parkingLot.getLot().containsKey(ticket)) {
            return parkingLot.getLot().remove(ticket);
        }
        else {
            throw new Exception();
        }
    }
}
