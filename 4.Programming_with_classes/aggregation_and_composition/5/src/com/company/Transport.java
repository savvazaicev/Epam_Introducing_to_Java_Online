package com.company;

import java.util.Scanner;

class Transport {
    private String[] names = new String[]{"самокат", "велосипед", "скутер", "машина", "поезд", "самолёт"};
    private int[] costs = new int[]{10, 50, 100, 150, 200, 300};

    public int offers(int amountOfMoney) {
        System.out.println("Выберите транспорт: ");
        for (int i = 0; i < this.names.length; i++) {
            System.out.println(" " + (i + 1) + "." + this.names[i] + " - " + this.costs[i] + "$");
        }
        Scanner in = new Scanner(System.in);
        int numOfTransport = in.nextInt() - 1;
        if (amountOfMoney - this.costs[numOfTransport] >= 0) {
            return this.costs[numOfTransport];
        } else {
            System.out.println("Ошибка! Недостаточно денег");
            return 0;
        }
    }
}