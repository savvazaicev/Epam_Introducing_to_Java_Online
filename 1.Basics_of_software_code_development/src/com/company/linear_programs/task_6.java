package com.company.linear_programs;

import java.util.Scanner;

//Для данной области составить линейную программу, которая печатает true, если точка с координатами (х, у)
//принадлежит закрашенной области, и false — в противном случае.
public class task_6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите кординаты точки (x,y): ");
        int x = in.nextInt();
        int y = in.nextInt();
        boolean bool = false;
        if (x <= 4 && x >= -4 && y >= -3 && y <= 0 ||
                x == 2 && y >= 0 && y <= 4) {
            bool = true;
        }
        System.out.println(bool);
    }
}
