package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

//Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
//Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
//номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
//Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
//назначения должны быть упорядочены по времени отправления.
public class Train {
    private String destination;
    private int number;
    private LocalDateTime departureTime;

    Train(String destination, int number, LocalDateTime departureTime) {
        this.destination = destination;
        this.number = number;
        this.departureTime = departureTime;
    }

    public static Train[] sortByNumber(Train[] trains) {
        for (int j = 0; j < trains.length - 1; j++) {
            for (int i = 0; i < trains.length - 1; i++) {
                if (trains[i].getNumber() > trains[i + 1].getNumber()) {
                    Train temp = trains[i];
                    trains[i] = trains[i + 1];
                    trains[i + 1] = temp;
                }
            }
        }
        return trains;
    }

    public static void output(Train[] trains) {
        for (Train i : trains) {
            System.out.println(i.getDestination() + " " + i.getNumber() + " "
                    + i.getDepartureTime().format(DateTimeFormatter.ofPattern("HH:mm")));
        }
        System.out.println();
    }

    public static void trainInfo(Train[] trains) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите номер поезда:");
        int num = in.nextInt() - 1;
        System.out.println("Пункт назначения: " + trains[num].getDestination());
        System.out.println("Время отправления: " + trains[num].getDepartureTime().format(DateTimeFormatter.ofPattern("HH:mm")));
        System.out.println();
    }

    public static Train[] sortByDestination(Train[] trains) {
        for (int j = 0; j < trains.length - 1; j++) {
            for (int i = 0; i < trains.length - 1; i++) {
                if (!compareByAlphabet(trains[i].getDestination(), trains[i + 1].getDestination())) {
                    Train temp = trains[i];
                    trains[i] = trains[i + 1];
                    trains[i + 1] = temp;
                }
                if (trains[i].getDestination().equals(trains[i + 1].getDestination())) {
                    if (trains[i].getDepartureTime().compareTo(trains[i + 1].getDepartureTime()) > 0) {
                        Train temp = trains[i];
                        trains[i] = trains[i + 1];
                        trains[i + 1] = temp;
                    }
                }
            }
        }
        return trains;
    }

    private static boolean compareByAlphabet(String word_1, String word_2) {
        String[] strings = {word_1, word_2};
        Arrays.sort(strings);
        return strings[0].equals(word_1);
    }

    public String getDestination() {
        return destination;
    }

    public int getNumber() {
        return number;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }
}
