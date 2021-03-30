package com.despegar.screenplay.model;

public class Flight {
    private final String originStr;
    private final String destinationStr;

    public Flight(String originStr, String destinationStr) {
        this.originStr = originStr;
        this.destinationStr = destinationStr;
    }

    public String getOriginStr() {
        return originStr;
    }

    public String getDestinationStr() {
        return destinationStr;
    }
}
