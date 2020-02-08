package com.company;

class Region {
    private String name;
    City[] cities;
    private int indexOfCapital;

    public Region(String name, City[] cities, int indexOfCapital) {
        this.name = name;
        this.cities = cities;
        this.indexOfCapital = indexOfCapital;
    }

    public City[] getCities() {
        return cities;
    }

    public int getIndexOfCapital() {
        return indexOfCapital;
    }

    public void regionalCenter() {
        City[] cities = getCities();
        System.out.println(cities[getIndexOfCapital()].getName());
    }
}
