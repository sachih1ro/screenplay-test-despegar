package com.despegar.screenplay.model;

public class FlightBuilder {

    private String origin;
    private String destination;

    public FlightBuilder(String origin) {
        this.origin = origin;
    }
    public Flight andDestination(String destination){
        return new Flight(this.origin, destination);
    }

    public static FlightBuilder origin(String origin){
        return new FlightBuilder(origin);
    }


}

