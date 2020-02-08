package com.company.loops;

import java.util.Scanner;

//Вычислить значения функции на отрезке [а,b] c шагом h.
public class task_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите крайние точки отрезка a, b и шаг h");
        int a = in.nextInt();
        int b = in.nextInt();
        int h = in.nextInt();
        int y = 0;
        for (int x = a; x <= b; ) {
            y = (x > 2) ? x : -x;
            x += h;
            System.out.println("Значение функции в точке " + x + " = " + y);
        }
    }
}
