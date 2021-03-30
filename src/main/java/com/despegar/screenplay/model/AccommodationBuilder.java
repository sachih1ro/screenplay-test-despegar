package com.despegar.screenplay.model;

public class AccommodationBuilder {

    private String origin;
    private String destination;

    public AccommodationBuilder(String origin) {
        this.origin = origin;
    }
    public Accommodation andDestination(String destination){
        return new Accommodation(this.origin, destination);
    }

    public static AccommodationBuilder origin(String origin){

        return new AccommodationBuilder(origin);
    }

}
