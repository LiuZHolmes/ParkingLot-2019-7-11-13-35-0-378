package com.thoughtworks.tdd;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy() {
        parkingLot = new ParkingLot();
    }

    public Ticket parkCarThenReturnTicket(Car car) throws Exception {
        if (!parkingLot.isFull() && !parkingLot.getLot().containsValue(car)) {
            Ticket ticket = new Ticket();
            parkingLot.getLot().put(ticket, car);
            return ticket;
        }
        else {
            throw new Exception();
        }
    }

    public Car fetchCarByTicket(Ticket ticket) throws Exception {
        if (parkingLot.getLot().containsKey(ticket)) {
            return parkingLot.getLot().remove(ticket);
        } else {
            throw new Exception();
        }
    }
}
