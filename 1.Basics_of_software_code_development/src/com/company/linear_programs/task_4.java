package com.company.linear_programs;

import java.util.Scanner;

//Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях).
//Поменять местами дробную и целую части числа и вывести полученное значение числа.
public class task_4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число вида nnn,ddd: ");
        double x = in.nextDouble() * 1000;
        double var = x % 1000 + Math.floor(x / 1000) / 1000;
        System.out.println("Полученное значение числа: " + var);
    }
}
