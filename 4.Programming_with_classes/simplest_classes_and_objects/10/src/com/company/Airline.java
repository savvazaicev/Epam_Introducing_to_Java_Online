package com.company;

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

    public int getDepartureTime() {
        return departureTime;
    }

    public String getDaysOfWeek() {
        return daysOfWeek;
    }
}