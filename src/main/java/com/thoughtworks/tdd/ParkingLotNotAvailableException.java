package com.thoughtworks.tdd;

public class ParkingLotNotAvailableException extends Exception {
    public ParkingLotNotAvailableException() {

    }

    public ParkingLotNotAvailableException(String message) {
        super(message);
    }
}
