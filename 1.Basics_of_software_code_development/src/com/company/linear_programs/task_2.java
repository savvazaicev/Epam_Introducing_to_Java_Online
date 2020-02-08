package com.company.linear_programs;

import java.util.Scanner;

//Вычислить значение выражения по формуле
//(все переменные принимают действительные значения).
public class task_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = 0;
        int b = 0;
        int c = 0;
        System.out.println("Введите аргументы a, b, c функции z: ");
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();
        double z = (b + Math.sqrt(Math.pow(b, 2) + 4 * a * c)) / (2 * a) - Math.pow(a, 3) * c + Math.pow(b, -2);
        System.out.println("z = " + z);
    }
}
