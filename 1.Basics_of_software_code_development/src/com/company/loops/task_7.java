package com.company.loops;

import java.util.Scanner;

//Для каждого натурального числа в промежутке от m до n вывести все делители,
//кроме единицы и самого числа. m и n вводятся с клавиатуры.
public class task_7 {

    public static void main(String[] args) {
        System.out.println("Введите m, n граничные числа промежутка: ");
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        for (double i = m; i < n; i++) {
            System.out.println("Все делители числа " + i + ": ");
            for (double j = 2; j < i; j++) {
                if (i % j == 0.0) {
                    System.out.println(j);
                }
            }
        }
    }
}
