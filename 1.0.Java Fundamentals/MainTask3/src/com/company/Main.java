package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите кол-во случайных чисел: ");
        int count = in.nextInt();
        for (int i = 0; i < count; i++)
        {
            System.out.println(Math.random());
        }
        for (int i = 0; i < count; i++)
        {
            System.out.print(Math.random());
        }
    }
}
