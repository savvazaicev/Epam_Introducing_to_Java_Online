package com.company.branching;

import java.util.Scanner;

//Найти max{min(a, b), min(c, d)}.
public class task_2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите числа a, b, c, d: ");
        int a = in.nextInt();
        int b = in.nextInt();
        int d = in.nextInt();
        int c = in.nextInt();
        int max = Math.max(Math.min(a, b), Math.min(c, d));
        System.out.println("max = " + max);
    }
}
