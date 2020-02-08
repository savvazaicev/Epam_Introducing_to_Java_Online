package com.company;

//Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
//и метод toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
//и методами. Задать критерии выбора данных и вывести эти данные на консоль.

import java.util.ArrayList;
import java.util.Arrays;

//Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
//Найти и вывести:
//a) список покупателей в алфавитном порядке;
//b) список покупателей, у которых номер кредитной карточки находится в заданном интервале
public class Main {

    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "Зайцев", "Савелий", "Юрьевич", "Пушкина, 1", 1234, 1);
        Customer customer2 = new Customer(2, "Трамп", "Дональд", "Иванович", "Пушкина, 2", 2345, 2);
        Customer customer3 = new Customer(3, "Цукерберг", "Марк", "Петрович", "Пушкина, 3", 3456, 3);
        Customer customer4 = new Customer(4, "Безос", "Джефф", "Николаевич", "Пушкина, 4", 4567, 4);
        Customer customer5 = new Customer(5, "Обама", "Барак", "Романович", "Пушкина, 5", 5678, 5);
        ArrayList<Customer> customerArrayList = new ArrayList<>(Arrays.asList(customer1, customer2, customer3, customer4, customer5));
        Customers customers = new Customers(customerArrayList);
        System.out.println("Список покупателей в алфавитном порядке (по фамилии): ");
        customers.output(customers.sortByAlphabet());
        System.out.println('\n' + "Список покупателей, у которых номер кредитной карточки находится в заданном интервале: ");
        customers.output(customers.sortByCreditCardNumber(2000,5000));
        System.out.println('\n' + "Данные по заданным критериям: ");
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() > 2 && customers.get(i).getId() < 5) {
                System.out.println(customers.get(i).toString());
            }
        }
    }
}
