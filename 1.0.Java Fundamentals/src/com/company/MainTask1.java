package com.company;

import java.util.Scanner;

//Приветствовать любого пользователя при вводе его имени через командную строку.
public class MainTask1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите своё имя");
        String name = in.nextLine();
        System.out.println("Привет, " + name);
    }
}