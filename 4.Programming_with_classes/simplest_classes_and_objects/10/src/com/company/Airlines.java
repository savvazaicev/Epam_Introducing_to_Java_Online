package com.company;

import java.util.ArrayList;

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
            if (i.getDaysOfWeek().contains(day)) {
                i.output();
            }
        }
        return sortedAirlines;
    }

    public ArrayList<Airline> listByDayOfWeek(String day, int departureTime) {
        ArrayList<Airline> sortedAirlines = new ArrayList<>();
        for (Airline i :
                airlines) {
            if (i.getDaysOfWeek().contains(day) && i.getDepartureTime() > departureTime) {
                i.output();
            }
        }
        return sortedAirlines;
    }
}