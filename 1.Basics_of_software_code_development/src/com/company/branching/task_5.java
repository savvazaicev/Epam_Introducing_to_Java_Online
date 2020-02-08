package com.company.branching;

import java.util.Scanner;

import static java.lang.Math.pow;

//Вычислить значение функции.
public class task_5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите x функции f(x): ");
        int x = in.nextInt();
        double y = 0;
        if (x <= 3) {
            y = pow(x, 2) - 3 * x + 9;
        } else {
            y = 1 / (pow(x, 3) + 6);
        }
        System.out.println("Значение функции f(x) = " + y);
    }
}
