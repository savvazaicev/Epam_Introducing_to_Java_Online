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

    public Region[] getRegions() {
        return regions;
    }

    public int getIndexOfCapital() {
        return indexOfCapital;
    }

    public int getArea() {
        return area;
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

