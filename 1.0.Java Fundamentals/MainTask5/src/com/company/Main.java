package com.company;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random(System.currentTimeMillis());
        int randomVar = 1 + rnd.nextInt(12);
        String[] month= new String []{"Январь", "Феварль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        System.out.println("Случайное число от 1 до 12: " + randomVar);
        System.out.println("Месяц: " + month[randomVar - 1]);
    }
}