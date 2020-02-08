package com.company.linear_programs;

import java.util.Scanner;

//Найдите значение функции: z = ( (a – 3 ) * b / 2) + c.
public class task_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = 0;
        int b = 0;
        int c = 0;
        int z = 0;
        System.out.println("Введите аргументы a, b, c функции z: ");
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();
        z = ((a - 3) * b / 2) + c;
        System.out.println("z = " + z);
    }
}
