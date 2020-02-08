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
public class Customer {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private int creditCardNumber;
    private int bankAccountNumber;

    public Customer(int id, String surname, String name, String patronymic,
                    String address, int creditCardNumber, int bankAccountNumber) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    public void output() {
        System.out.println(toString());
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setBankAccountNumber(int bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getAddress() {
        return address;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public int getBankAccountNumber() {
        return bankAccountNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", creditCardNumber=" + creditCardNumber +
                ", bankAccountNumber=" + bankAccountNumber +
                '}';
    }
}

class Customers {
    private ArrayList<Customer> customers;

    public Customers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public void output(ArrayList<Customer> customers) {
        for (Customer i : customers) {
            i.output();
        }
    }

    public ArrayList<Customer> sortByAlphabet() {
        ArrayList<Customer> sortedCustomers = customers;
        for (int j = 0; j < sortedCustomers.size() - 1; j++) {
            for (int i = 0; i < sortedCustomers.size() - 1; i++) {
                if (!compareByAlphabet(sortedCustomers.get(i).getSurname(), sortedCustomers.get(i + 1).getSurname())) {
                    Customer temp = sortedCustomers.get(i);
                    sortedCustomers.remove(i);
                    sortedCustomers.add(i + 1, temp);
                }
            }
        }
        return customers;
    }

    public ArrayList<Customer> sortByCreditCardNumber(int rangeFrom, int rangeTo) {
        ArrayList<Customer> sortedCustomers = new ArrayList<>();
        for (Customer i : customers) {
            if (i.getCreditCardNumber() >= rangeFrom && i.getCreditCardNumber() <= rangeTo) {
                sortedCustomers.add(i);
            }
        }
        return sortedCustomers;
    }

    private static boolean compareByAlphabet(String word_1, String word_2) {
        String[] strings = {word_1, word_2};
        Arrays.sort(strings);
        return strings[0].equals(word_1);
    }

    public int size() {
        return this.customers.size();
    }

    public Customer get(int i) {
        return this.customers.get(i);
    }
}
