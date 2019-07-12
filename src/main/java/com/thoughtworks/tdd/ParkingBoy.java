package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingBoy {

    private static final Car nullCar = null;

    private int numberOfParkingLots;

    private List<ParkingLot> parkingLots;

    public ParkingBoy() {
        parkingLots = new ArrayList<>();
        numberOfParkingLots = 2;
        for (int i = 0;i < numberOfParkingLots;i++)
        {
            parkingLots.add(new ParkingLot());
        }
    }

    public Ticket parkCarThenReturnTicket(Car car) throws Exception {
        if (isParkingLotAvailable() && isCarEligible(car)) {
            Ticket ticket = new Ticket();
            parkingLots.stream().filter(x -> x.isAvailable())
                    .collect(Collectors.toList()).get(0)
                    .getLot().put(ticket, car);
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
            return parkingLots.stream().filter(x -> x.getLot().containsKey(ticket))
                    .collect(Collectors.toList())
                    .get(0).getLot().remove(ticket);
        } else {
            throw new Exception();
        }
    }

    private boolean isParkingLotAvailable() throws Exception {
        if (parkingLots.stream().anyMatch(x -> x.isAvailable()))
            return true;
        else throw new Exception("Not enough position");
    }

    private boolean isCarEligible(Car car) {
        return parkingLots.stream().allMatch(x -> !x.getLot().containsValue(car)) && car != nullCar;
    }

    private boolean isTicketEligible(Ticket ticket) throws Exception {
        if (parkingLots.stream().anyMatch(x -> x.getLot().containsKey(ticket)))
            return true;
        else throw new Exception("Unrecognized parking ticket");
    }

    public boolean isParkingLotAvailableAt(int index) {
        return parkingLots.get(index).isAvailable();
    }

    public List<Integer> getOccupationOfParkingLots(){
        return parkingLots.stream().map(x -> x.getLot().size()).collect(Collectors.toList());
    }
}
