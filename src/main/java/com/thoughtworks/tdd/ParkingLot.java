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

    public ParkingLot() {
        lot = new HashMap<>();
        capacity = defaultCapacity;
    }

    public HashMap<Ticket, Car> getLot() {
        return lot;
    }

    public Integer getOccupation() {
        return lot.size();
    }

    public Integer getEmptyPositions() {
        return capacity - getOccupation();
    }

    public int getCapacity() {
        return capacity;
    }

    public Double getAvailablePositionRate() {
        return getEmptyPositions().doubleValue() / getCapacity();
    }

    boolean isAvailable() {
        return lot.size() <= capacity;
    }
}
