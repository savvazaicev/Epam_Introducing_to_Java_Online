package com.company;

import java.util.Scanner;

//Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
//различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора.
//Учитывать возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        System.out.println("Введите кол-во дней: ");
//        int count = in.nextInt();
//        System.out.println("Введите кол-во денег: ");
//        int amountOfMoney = in.nextInt();
//        Vouchers vouchers = new Vouchers(count, amountOfMoney);
        Vouchers vouchers = new Vouchers(5, 5000);
        System.out.println("Отсортировать путевки по убыванию цены?" + "\n" + "1.Да" + "\n" + "2.Нет");
        if (in.nextInt() == 1) {
            vouchers.sort();
        }
        vouchers.offers();
    }
}