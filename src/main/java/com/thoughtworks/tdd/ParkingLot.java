package com.thoughtworks.tdd;

import java.util.HashMap;

public class ParkingLot {

    private HashMap<Ticket, Car> lot;

    private int size;

    public ParkingLot(int size) {
        lot = new HashMap<>();
        this.size = size;
    }

    ParkingLot() {
        lot = new HashMap<>();
    }

    public HashMap<Ticket, Car> getLot() {
        return lot;
    }

    boolean isFull() {
        return lot.size() == size;
    }
}
