package com.company;

import static com.company.BankAccount.findBankAcc;

//Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
//счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам.
//Вычисление суммы по всем счетам, имеющим положительный и отрицательный балансы отдельно.
public class Main {

    public static void main(String[] args) {
        Client client1 = new Client(1, "Савелий", "Зайцев");
        Client client2 = new Client(2, "Дональд", "Трамп", 10000);
        client1.addBankAccount(1000);
        client2.addBankAccount(100000);
        client2.addBankAccount(-100);
        System.out.println("Количество денег на первом счету: ");
        System.out.println(client1.getBankAccount(0).getCountOfMoney());
        System.out.println("Добавляем деньги на первый счёт: ");
        client1.getBankAccount(0).setCountOfMoney(100);
        System.out.println(client1.getBankAccount(0).getCountOfMoney());
        System.out.println("Блокируем второй счёт: ");
        client1.getBankAccount(1).setBlocked(true);
        if (client1.getBankAccount(1).isBlocked()) {
            System.out.println("Счёт заблокирован");
        }
        System.out.println("\n" + "Поиск счёта по имени и индексу: ");
        Client[] clients = {client1, client2};
        String name = "Дональд";
        int index = 1;
        findBankAcc(name, index, clients);
        System.out.println("\n" + "Счета в банке второго клиента: ");
        for (int i = 0; i < client2.getBankAccounts().size(); i++) {
            client2.getBankAccount(i).output();
        }
        System.out.println("\n" + "Сортировка этих счётов по убыванию кол-ва денег: ");
        client2.sortBankAcc();
        for (int i = 0; i < client2.getBankAccounts().size(); i++) {
            client2.getBankAccount(i).output();
        }
        System.out.println("\n" + "Общая сумма по счетам второго клиента: ");
        client2.sumBankAcc(false);
        System.out.println("\n" + "Общая сумма по положительным и отрицательным счетам второго клиента: ");
        client2.sumBankAcc(true);
    }
}
