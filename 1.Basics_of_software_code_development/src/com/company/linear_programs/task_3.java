package com.company.linear_programs;

import java.util.Scanner;

//Вычислить значение выражения по формуле
//(все переменные принимают действительные значения).
public class task_3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = 0;
        int y = 0;
        System.out.println("Введите x, y: ");
        x = in.nextInt();
        y = in.nextInt();
        double z = (Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y)) * Math.tan(x * y);
        System.out.println("z = " + z);
    }
}
