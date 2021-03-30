package com.despegar.screenplay.exceptions;

public class NoFlightFoundError extends AssertionError{

    public static final String MESSAGE_NO_FLIGHT_FOUND =
            "No flight was found";

    public NoFlightFoundError(String message, Throwable cause) {
        super(message, cause);
    }

    public static String withMessageBy(String route) {
        return MESSAGE_NO_FLIGHT_FOUND;
    }

}
