package com.company.linear_programs;

import java.util.Scanner;

//Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах.
//Вывести данное значение длительности в часах, минутах и секундах в следующей форме:
//ННч ММмин SSc.
public class task_5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите кол-во секунд: ");
        int t = in.nextInt();
        int min = t / 60;
        int hours = 0;
        while (min >= 60) {
            min -= 60;
            hours++;
        }
        int sec = t - hours * 3600 - min * 60;
        System.out.println(hours + "ч " + min + "мин " + sec + "с");
    }
}
