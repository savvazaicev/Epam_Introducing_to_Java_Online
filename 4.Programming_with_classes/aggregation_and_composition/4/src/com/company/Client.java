package com.company;

import java.util.ArrayList;

//Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
//счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам.
//Вычисление суммы по всем счетам, имеющим положительный и отрицательный балансы отдельно.
public class Client {
    private int id;
    private String name;
    private String surname;
    private ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    public Client(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        addBankAccount();
    }

    public Client(int id, String name, String surname, int countOfMoney) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        addBankAccount(countOfMoney);
    }

    public String getName() {
        return name;
    }

    public BankAccount getBankAccount(int index) {
        return bankAccounts.get(index);
    }

    public ArrayList<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void addBankAccount() {
        BankAccount bankAccount = new BankAccount();
        this.bankAccounts.add(bankAccount);
    }

    public void addBankAccount(int countOfMoney) {
        BankAccount bankAccount = new BankAccount(countOfMoney);
        this.bankAccounts.add(bankAccount);
    }

    public void sortBankAcc() {
        ArrayList<BankAccount> bankAccounts = getBankAccounts();
        for (int j = 0; j < bankAccounts.size() - 1; j++) {
            for (int i = j; i < bankAccounts.size() - 1; i++) {
                if (bankAccounts.get(i).getCountOfMoney() < bankAccounts.get(i + 1).getCountOfMoney()) {
                    bankAccounts.add(i, bankAccounts.get(i + 1));
                    bankAccounts.remove(i + 2);
                }
            }
        }
    }

    public void sumBankAcc(boolean inDetail) {
        ArrayList<BankAccount> bankAccounts = getBankAccounts();
        int sum = 0;
        if (inDetail) {
            int negativeSum = 0;
            for (int i = 0; i < bankAccounts.size(); i++) {
                int countOfMoney = bankAccounts.get(i).getCountOfMoney();
                if (countOfMoney >= 0) {
                    sum += countOfMoney;
                } else {
                    negativeSum += countOfMoney;
                }
            }
            System.out.println(sum);
            System.out.println(negativeSum);
        } else {
            for (int i = 0; i < bankAccounts.size(); i++) {
                sum += bankAccounts.get(i).getCountOfMoney();
            }
            System.out.println(sum);
        }
    }
}
