package com.despegar.screenplay.exceptions;

public class CanNotLoadPaymentGateway extends AssertionError{
    public static final String MESSAGE_CAN_NOT_LOAD_PAYMENT_GATEWAY =
            "Can not load the payment gateway page";

    public CanNotLoadPaymentGateway(String message, Throwable cause) {
        super(message, cause);
    }

    public static String withMessageBy(String route) {
        return MESSAGE_CAN_NOT_LOAD_PAYMENT_GATEWAY;
    }

}