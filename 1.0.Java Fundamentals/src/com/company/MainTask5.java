package com.company;
import java.util.Scanner;

//Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу.
//Осуществить проверку корректности ввода чисел.
public class MainTask5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число: ");
        int var = in.nextInt();
        if (var < 1 || var > 12) {
            System.out.println("Ошибка! Введённое число должно находиться в диапазоне от 1 до 12");
            return;
        }
        String[] month= new String []{"Январь", "Феварль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        System.out.println("Месяц: " + month[var - 1]);
    }
}