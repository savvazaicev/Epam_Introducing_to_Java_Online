package com.company.branching;

import java.util.Scanner;

//Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3).
//Определить, будут ли они расположены на одной прямой.
public class task_3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите координаты точек A(x1,y1), B(x2,y2), C(x3,y3): ");
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        int x3 = in.nextInt();
        int y3 = in.nextInt();
        Boolean bool = (x1 == x2 && x2 == x3 || y1 == y2 && y2 == y3);
        if (bool) {
            System.out.println("Точки расположены на одной прямой");
        } else {
            System.out.println("Точки не расположены на одной прямой");
        }
    }
}
