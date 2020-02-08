package com.company;

import java.util.ArrayList;

//Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
//и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
//методами. Задать критерии выбора данных и вывести эти данные на консоль.
//Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
//Найти и вывести:
//a) список рейсов для заданного пункта назначения;
//b) список рейсов для заданного дня недели;
//c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
public class Airline {
    private String destination;
    private int flightNumber;
    private String typeOfPlane;
    private int departureTime;
    private String daysOfWeek;

    public Airline(String destination, int flightNumber, String typeOfPlane, int departureTime, String daysOfWeek) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.typeOfPlane = typeOfPlane;
        this.departureTime = departureTime;
        this.daysOfWeek = daysOfWeek;
    }

    public void output() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Airline{" +
                "destination='" + destination + '\'' +
                ", flightNumber=" + flightNumber +
                ", typeOfPlane='" + typeOfPlane + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", daysOfWeek='" + daysOfWeek + '\'' +
                '}';
    }

    public String getDestination() {
        return destination;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getTypeOfPlane() {
        return typeOfPlane;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public String getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setTypeOfPlane(String typeOfPlane) {
        this.typeOfPlane = typeOfPlane;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public void setDaysOfWeek(String daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }
}

class Airlines {
    private ArrayList<Airline> airlines;

    public Airlines(ArrayList<Airline> airlines) {
        this.airlines = airlines;
    }

    public void output(ArrayList<Airline> airlines) {
        for (Airline i :
                airlines) {
            i.output();
        }
    }

    public int size() {
        return this.airlines.size();
    }

    public Airline get(int i) {
        return this.airlines.get(i);
    }

    public ArrayList<Airline> listByDestination(String destination) {
        ArrayList<Airline> sortedAirlines = new ArrayList<>();
        for (Airline i :
                airlines) {
            if (i.getDestination().equals(destination)) {
                i.output();
            }
        }
        return sortedAirlines;
    }

    public ArrayList<Airline> listByDayOfWeek(String day) {
        ArrayList<Airline> sortedAirlines = new ArrayList<>();
        for (Airline i :
                airlines) {
            if (i.getDaysOfWeek().indexOf(day) != -1) {
                i.output();
            }
        }
        return sortedAirlines;
    }

    public ArrayList<Airline> listByDayOfWeek(String day, int departureTime) {
        ArrayList<Airline> sortedAirlines = new ArrayList<>();
        for (Airline i :
                airlines) {
            if (i.getDaysOfWeek().indexOf(day) != -1 && i.getDepartureTime() > departureTime) {
                i.output();
            }
        }
        return sortedAirlines;
    }
}
