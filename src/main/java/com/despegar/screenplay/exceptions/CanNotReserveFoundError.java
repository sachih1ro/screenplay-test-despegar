package com.despegar.screenplay.exceptions;

public class CanNotReserveFoundError extends AssertionError{
    public static final String MESSAGE_CAN_NOT_RESERVE_FOUND =
            "Can not reserve this accommodation";

    public CanNotReserveFoundError(String message, Throwable cause) {
        super(message, cause);
    }

    public static String withMessageBy(String route) {
        return MESSAGE_CAN_NOT_RESERVE_FOUND;
    }

}
