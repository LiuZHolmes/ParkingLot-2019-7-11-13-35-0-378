package com.thoughtworks.tdd;

public class ParkingBoy {
    private static final Car nullCar = null;

    private ParkingLot parkingLot;

    public ParkingBoy() {
        parkingLot = new ParkingLot();
    }

    public Ticket parkCarThenReturnTicket(Car car) throws Exception {
        if (isParkingLotAvailable(car) && isCarEligible(car)) {
            Ticket ticket = new Ticket();
            parkingLot.getLot().put(ticket, car);
            return ticket;
        } else {
            throw new Exception();
        }
    }

    public Car fetchCarByTicket() throws Exception {
        throw new Exception("Please provide your parking ticket");
    }

    public Car fetchCarByTicket(Ticket ticket) throws Exception {
        if (isTicketEligible(ticket)) {
            return parkingLot.getLot().remove(ticket);
        } else {
            throw new Exception();
        }
    }

    private boolean isParkingLotAvailable(Car car) throws Exception {
        if (!parkingLot.isFull())
            return true;
        else throw new Exception("Not enough position");
    }

    private boolean isCarEligible(Car car) {
        return !parkingLot.getLot().containsValue(car) && car != nullCar;
    }

    private boolean isTicketEligible(Ticket ticket) throws Exception {
        if (parkingLot.getLot().containsKey(ticket))
            return true;
        else throw new Exception("Unrecognized parking ticket");
    }
}
