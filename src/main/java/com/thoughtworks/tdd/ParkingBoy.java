package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParkingBoy {

    private static final Car nullCar = null;

    private final int defaultNumberOfParkingLots = 2;

    protected List<ParkingLot> parkingLots;

    public ParkingBoy() {
        parkingLots = IntStream.rangeClosed(1, defaultNumberOfParkingLots).boxed().map(x -> new ParkingLot()).collect(Collectors.toList());
    }

    public Ticket parkCarThenReturnTicket(Car car) throws Exception {
        testIfParkingIsDoable(car);
        Ticket ticket = new Ticket();
        parkingLots.stream().filter(ParkingLot::isAvailable)
                .collect(Collectors.toList()).get(0)
                .getLot().put(ticket, car);
        return ticket;
    }

    private void testIfParkingIsDoable(Car car) throws ParkingLotNotAvailableException, CarNotEligibleException {
        isParkingLotAvailable() ;
        isCarEligible(car);
    }

    public void fetchCarByTicket() throws TicketNotEligibleException {
        throw new TicketNotEligibleException("Please provide your parking ticket");
    }

    public Car fetchCarByTicket(Ticket ticket) throws TicketNotEligibleException {
        if (isTicketEligible(ticket)) {
            return parkingLots.stream().filter(x -> x.getLot().containsKey(ticket))
                    .collect(Collectors.toList())
                    .get(0).getLot().remove(ticket);
        } else {
            throw new TicketNotEligibleException();
        }
    }

    protected boolean isParkingLotAvailable() throws ParkingLotNotAvailableException {
        if (parkingLots.stream().anyMatch(ParkingLot::isAvailable))
            return true;
        else throw new ParkingLotNotAvailableException("Not enough position");
    }

    protected boolean isCarEligible(Car car) throws CarNotEligibleException {
        if (parkingLots.stream().noneMatch(x -> x.getLot().containsValue(car)) && car != nullCar)
            return true;
        else throw new CarNotEligibleException();
    }

    private boolean isTicketEligible(Ticket ticket) throws TicketNotEligibleException {
        if (parkingLots.stream().anyMatch(x -> x.getLot().containsKey(ticket)))
            return true;
        else throw new TicketNotEligibleException("Unrecognized parking ticket");
    }

    public boolean isParkingLotAvailableAt(int index) {
        return parkingLots.get(index).isAvailable();
    }

    public List<Integer> getOccupationOfParkingLots() {
        return parkingLots.stream().map(ParkingLot::getOccupation).collect(Collectors.toList());
    }
}
