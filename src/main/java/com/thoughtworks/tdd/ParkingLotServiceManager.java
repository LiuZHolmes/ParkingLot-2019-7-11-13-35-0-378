package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotServiceManager extends ParkingBoy{

    private List<ParkingBoy> managementList;

    public ParkingLotServiceManager() {
        managementList = new ArrayList<>();
    }

    public void addToManagementList(ParkingBoy parkingBoy) {
        managementList.add(parkingBoy);
    }

    public boolean doesParkingBoyInManagementList(ParkingBoy parkingBoy) {
        return managementList.contains(parkingBoy);
    }

    public Ticket ParkCarThenReturnTicketBySpecificParkingBoy(Car car) throws Exception {
        return managementList.get(0).parkCarThenReturnTicket(car);
    }

    public Car fetchCarByTicketBySpecificParkingBoy(Ticket ticket) throws Exception {
        return managementList.get(0).fetchCarByTicket(ticket);
    }

    public void fetchCarByTicketBySpecificParkingBoy() throws Exception {
        super.fetchCarByTicket();
    }
}
