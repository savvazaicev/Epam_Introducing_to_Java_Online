package com.company;

import java.util.Scanner;

class Nutrition {
    private String[] names = new String[]{"питьевая вода", "фаст-фуд", "только обед",
            "3-ч разовове питание", "шведский стол"};
    private int[] costs = new int[]{10, 50, 100, 200, 300};

    public int offers(int amountOfMoney) {
        System.out.println("Выберите питание: ");
        for (int i = 0; i < this.names.length; i++) {
            System.out.println(" " + (i + 1) + "." + this.names[i] + " - " + this.costs[i] + "$");
        }
        Scanner in = new Scanner(System.in);
        int numOfNutrition = in.nextInt() - 1;
        if (amountOfMoney - this.costs[numOfNutrition] >= 0) {
            return this.costs[numOfNutrition];
        } else {
            System.out.println("Ошибка! Недостаточно денег");
            return 0;
        }
    }
}