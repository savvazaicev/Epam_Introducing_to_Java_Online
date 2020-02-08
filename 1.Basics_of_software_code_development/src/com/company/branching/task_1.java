package com.company.branching;

import java.util.Scanner;

//Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник, и если да,
//то будет ли он прямоугольным.
public class task_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите 2 угла треугольника: ");
        int cornerOne = in.nextInt();
        int cornerTwo = in.nextInt();
        Boolean triangleExist = 180 - cornerOne - cornerTwo > 0 &&
                cornerOne != 0 && cornerTwo != 0;
        Boolean triangleRight = cornerOne == 90 || cornerTwo == 90 || cornerOne + cornerTwo == 90;
        if (triangleExist) {
            System.out.print("Треугольник существует,");
        } else {
            System.out.println("Треугольник не существует");
            System.exit(0);
        }
        if (triangleRight) {
            System.out.println(" он прямоугольный");
        } else {
            System.out.println(" он не прямоугольный");
        }
    }
}
