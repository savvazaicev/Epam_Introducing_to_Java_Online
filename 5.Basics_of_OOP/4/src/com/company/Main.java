package com.company;

//Создать консольное приложение, удовлетворяющее следующим требованиям:
//• Приложение должно быть объектно-, а не процедурно-ориентированным.
//• Каждый класс должен иметь отражающее смысл название и информативный состав.
//• Наследование должно применяться только тогда, когда это имеет смысл.
//• При кодировании должны быть использованы соглашения об оформлении кода java code convention.
//• Классы должны быть грамотно разложены по пакетам.
//• Консольное меню должно быть минимальным.
//• Для хранения данных можно использовать файлы.

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере
//дракона. Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и
//выбора сокровищ на заданную сумму.
public class Main {

    public static void main(String[] args) throws IOException {
        int amountOfMoney = 500;
        Treasures treasures = new Treasures();
        FileReader fr = new FileReader("treasures.txt");
        Scanner sc = new Scanner(fr);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String name = str.substring(0, str.indexOf(" "));
            int cost = Integer.parseInt(str.substring(str.indexOf(" ") + 1));
            treasures.add(name, cost);
        }
        fr.close();
        System.out.println("Выберите номер сокровища, которое вы хотите купить: ");
        System.out.println("-1.Завершить покупку сокровищ и подсчитать баланс");
        System.out.println("0.Купить самое дорогое сокровище");
        treasures.outputAll();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            if (num == -1) {
                System.out.println("Остаток на балансе: " + amountOfMoney + "$");
                break;
            }
            if (num == 0) {
                int maxCostIndex = treasures.buyMostExpensive();
                if (amountOfMoney - treasures.getCost(maxCostIndex) >= 0) {
                    amountOfMoney -= treasures.getCost(maxCostIndex);
                    System.out.println("Покупка произошла успешно!");
                } else {
                    System.out.println("Ошибка! Недостаточно денег.");
                }
            } else {
                if (amountOfMoney - treasures.buy(num - 1) >= 0) {
                    amountOfMoney -= treasures.buy(num - 1);
                    System.out.println("Покупка произошла успешно!");
                } else {
                    System.out.println("Ошибка! Недостаточно денег.");
                }
            }
        }
    }
}