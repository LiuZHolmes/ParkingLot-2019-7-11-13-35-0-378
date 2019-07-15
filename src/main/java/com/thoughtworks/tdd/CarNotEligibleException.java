package com.thoughtworks.tdd;

public class CarNotEligibleException extends Exception {
    public CarNotEligibleException(String message) {
        super(message);
    }

    public CarNotEligibleException() {
    }
}
