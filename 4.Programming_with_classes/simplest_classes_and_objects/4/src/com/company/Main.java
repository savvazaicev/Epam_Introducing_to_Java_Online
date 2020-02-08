package com.company;

import java.time.LocalDateTime;

import static com.company.Train.*;

//Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
//Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
//номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
//Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
//назначения должны быть упорядочены по времени отправления.
public class Main {

    public static void main(String[] args) {
        Train train1 = new Train("Minsk", 1, LocalDateTime.parse("2019-12-31T12:30"));
        Train train2 = new Train("Brest", 2, LocalDateTime.parse("2019-12-31T04:30"));
        Train train3 = new Train("Vitebsk", 3, LocalDateTime.parse("2019-12-31T05:30"));
        Train train4 = new Train("Minsk", 4, LocalDateTime.parse("2019-12-31T06:30"));
        Train train5 = new Train("Moscow", 5, LocalDateTime.parse("2019-12-31T07:30"));
        Train[] trains = {train5, train4, train3, train2, train1};
        System.out.println("Сортировка по номерам поездов: ");
        sortByNumber(trains);
        output(trains);
        trainInfo(trains);
        System.out.println("Сортировка по пункту назначения: ");
        sortByDestination(trains);
        output(trains);
    }
}
