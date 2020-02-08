package com.company.branching;

import java.util.Scanner;

//Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича.
//Определить, пройдет ли кирпич через отверстие.
public class task_4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размеры A, B прямоугольного отверстия");
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println("Введите размеры x, y, z кирпича");
        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();
        Boolean willPass = a >= x && b >= y || a >= y && b >= z || a >= z && b >= a;
        if (willPass) {
            System.out.println("Кирпич пройдёт через отверстие");
        } else {
            System.out.println("Кирпич пройдёт через отверстие");
        }
    }
}
