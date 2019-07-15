package com.thoughtworks.tdd;

public class TicketNotEligibleException extends  Exception{
    public TicketNotEligibleException(String message) {
        super(message);
    }

    public TicketNotEligibleException() {
    }
}
