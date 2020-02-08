package com.company;

import java.util.ArrayList;
import java.util.Arrays;

//Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
//и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
//методами. Задать критерии выбора данных и вывести эти данные на консоль.
//Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
//Найти и вывести:
//a) список рейсов для заданного пункта назначения;
//b) список рейсов для заданного дня недели;
//c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
public class Main {

    public static void main(String[] args) {
        Airline airline1 = new Airline("Abcde", 1, "a", 12, "Mon Thu");
        Airline airline2 = new Airline("Bcdef", 2, "b", 4, "Thu");
        Airline airline3 = new Airline("Abcde", 3, "a", 5, "Mon");
        Airline airline4 = new Airline("Defgh", 4, "b", 6, "Fr");
        Airline airline5 = new Airline("Efghi", 5, "a", 7, "Fr Thu");
        ArrayList<Airline> airlinesArrayList = new ArrayList<>(Arrays.asList(airline1, airline2, airline3, airline4, airline5));
        Airlines airlines = new Airlines(airlinesArrayList);
        System.out.println("Cписок рейсов для заданного пункта назначения: ");
        airlines.output(airlines.listByDestination("Abcde"));
        System.out.println('\n' + "Список рейсов для заданного дня недели: ");
        airlines.output(airlines.listByDayOfWeek("Thu"));
        System.out.println('\n' + "Список рейсов для заданного дня недели, время вылета для которых больше заданного: ");
        airlines.output(airlines.listByDayOfWeek("Thu", 5));
        System.out.println('\n' + "Данные по заданным критериям: ");
        for (int i = 0; i < airlines.size(); i++) {
            if (airlines.get(i).getFlightNumber() > 2 && airlines.get(i).getFlightNumber() < 5) {
                System.out.println(airlines.get(i).toString());
            }
        }
    }
}