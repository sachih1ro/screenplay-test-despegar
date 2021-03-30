package com.despegar.screenplay.exceptions;

public class NoFlightsFoundError extends AssertionError{

    public static final String MESSAGE_NO_FLIGHT_FOUND =
            "No flights was found";

    public NoFlightsFoundError(String message, Throwable cause) {
        super(message, cause);
    }

    public static String withMessageBy(String route) {
        return MESSAGE_NO_FLIGHT_FOUND;
    }

}
