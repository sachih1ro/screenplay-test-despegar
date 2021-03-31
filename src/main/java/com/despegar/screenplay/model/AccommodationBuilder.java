package com.despegar.screenplay.model;

public class AccommodationBuilder {

    private String location;

    public AccommodationBuilder(String location) {
        this.location = location;
    }

    public static Accommodation location(String location){
        return new Accommodation(location);
    }

}
