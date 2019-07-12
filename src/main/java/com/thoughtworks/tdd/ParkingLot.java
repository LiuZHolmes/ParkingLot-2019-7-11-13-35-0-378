package com.thoughtworks.tdd;

import java.util.HashMap;

public class ParkingLot {

    private HashMap<Ticket, Car> lot;

    ParkingLot() {
        lot = new HashMap<>();
    }

    public HashMap<Ticket, Car> getLot() {
        return lot;
    }
}
