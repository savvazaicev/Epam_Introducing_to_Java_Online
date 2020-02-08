package com.company;

import java.util.ArrayList;
import java.util.Arrays;

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