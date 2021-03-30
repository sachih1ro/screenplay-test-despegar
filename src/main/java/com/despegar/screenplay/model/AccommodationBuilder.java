package com.despegar.screenplay.model;

public class AccommodationBuilder {

    private String location;

    public AccommodationBuilder(String location) {
        this.location = location;
    }
    public Accommodation in(String location){
        return new Accommodation(this.location);
    }

    public static AccommodationBuilder origin(String location){

        return new AccommodationBuilder(location);
    }

}
