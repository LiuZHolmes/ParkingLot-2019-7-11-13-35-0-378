package com.thoughtworks.tdd;

import java.util.HashMap;

public class ParkingLot {

    private static final int defaultCapacity = 10;

    private HashMap<Ticket, Car> lot;

    private int capacity;

    public ParkingLot(int capacity) {
        lot = new HashMap<>();
        this.capacity = capacity;
    }

    ParkingLot() {
        lot = new HashMap<>();
        capacity = defaultCapacity;
    }

    public HashMap<Ticket, Car> getLot() {
        return lot;
    }


    boolean isFull() {
        return lot.size() == capacity;
    }
}
