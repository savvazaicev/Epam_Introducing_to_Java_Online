package com.company;

//Создать объект класса Государство, используя классы Область, Район, Город.
//Методы: вывести на консоль столицу, количество областей, площадь, областные центры.
public class State {
    private String name;
    Region[] regions;
    private int indexOfCapital;
    private int area;

    public State(String name, Region[] regions, int indexOfCapital, int area) {
        this.name = name;
        this.regions = regions;
        this.indexOfCapital = indexOfCapital;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region[] getRegions() {
        return regions;
    }

    public void setRegions(Region[] regions) {
        this.regions = regions;
    }

    public int getIndexOfCapital() {
        return indexOfCapital;
    }

    public void setIndexOfCapital(int indexOfCapital) {
        this.indexOfCapital = indexOfCapital;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void capital() {
        Region[] regions = getRegions();
        int i = getIndexOfCapital();
        City[] cities = regions[i].getCities();
        int index = regions[i].getIndexOfCapital();
        System.out.println(cities[i].getName());
    }

    public void numOfRegions() {
        System.out.println(getRegions().length);
    }
}

class Region {
    private String name;
    City[] cities;
    private int indexOfCapital;

    public Region(String name, City[] cities, int indexOfCapital) {
        this.name = name;
        this.cities = cities;
        this.indexOfCapital = indexOfCapital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City[] getCities() {
        return cities;
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }

    public int getIndexOfCapital() {
        return indexOfCapital;
    }

    public void setIndexOfCapital(int indexOfCapital) {
        this.indexOfCapital = indexOfCapital;
    }

    public void regionalCenter() {
        City[] cities = getCities();
        System.out.println(cities[getIndexOfCapital()].getName());
    }
}

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

    public void setName(String name) {
        this.name = name;
    }

    public District getDistricts() {
        return districts;
    }

    public void setDistricts(District districts) {
        this.districts = districts;
    }
}

class District {
    private String name;

    public District(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}