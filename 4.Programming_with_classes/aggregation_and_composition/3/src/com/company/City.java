package com.company;

class City {
    private String name;
    District districts;

    public City(String name, District districts) {
        this.name = name;
        this.districts = districts;
    }

    public String getName() {
        return name;
    }
}
