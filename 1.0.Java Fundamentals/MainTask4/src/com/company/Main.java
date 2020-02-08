package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите кол-во чисел");
        int count = in.nextInt();
        int sum = 0;
        int product = 1;
        int var = 0;
        System.out.println("Введите целые числа");
        for (int i = 0; i < count; i++) {
            var = in.nextInt();
            sum += var;
            product *= var;
        }
        System.out.println("Сумма чисел " + sum);
        System.out.println("Произведение чисел " + product);
    }
}
