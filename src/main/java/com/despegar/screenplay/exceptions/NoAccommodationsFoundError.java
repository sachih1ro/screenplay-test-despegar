package com.despegar.screenplay.exceptions;

public class NoAccommodationsFoundError extends AssertionError{

    public static final String MESSAGE_NO_ACCOMMODATION_FOUND =
            "No accommodation was found";

    public NoAccommodationsFoundError(String message, Throwable cause) {
        super(message, cause);
    }

    public static String withMessageBy(String route) {
        return MESSAGE_NO_ACCOMMODATION_FOUND;
    }

}
