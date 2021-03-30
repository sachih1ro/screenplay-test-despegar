package com.despegar.screenplay.exceptions;

public class NoAccommodationFoundError extends AssertionError{

    public static final String MESSAGE_NO_ACCOMMODATION_FOUND =
            "No accommodation was found";

    public NoAccommodationFoundError(String message, Throwable cause) {
        super(message, cause);
    }

    public static String withMessageBy(String route) {
        return MESSAGE_NO_ACCOMMODATION_FOUND;
    }

}
