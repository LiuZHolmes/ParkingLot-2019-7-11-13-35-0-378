package com.thoughtworks.tdd;

public class ParkingBoy {
    private static final Car nullCar = null;

    private ParkingLot parkingLot;

    public ParkingBoy() {
        parkingLot = new ParkingLot();
    }

    public Ticket parkCarThenReturnTicket(Car car) throws Exception {
        if (isParkingLotAvaliable(car) && isCarEligible(car) ) {
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

    private boolean isParkingLotAvaliable(Car car){
        return !parkingLot.isFull() && !parkingLot.getLot().containsValue(car);
    }

    private boolean isCarEligible(Car car){
        return car != nullCar;
    }
}
