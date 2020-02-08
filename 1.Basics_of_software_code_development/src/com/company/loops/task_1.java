package com.company.loops;

import java.util.Scanner;

//Напишите программу, где пользователь вводит любое целое положительное число.
//А программа суммирует все числа от 1 до введенного пользователем числа.
public class task_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите целое положительное число: ");
        int var = in.nextInt();
        int sum = 0;
        for (int i = 1; i <= var; i++) {
            sum += i;
        }
        System.out.println("Сумма чисел до заданного числа: " + sum);
    }
}
