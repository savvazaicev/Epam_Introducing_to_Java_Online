package com.company;

//Отобразить в окне консоли аргументы командной строки в обратном порядке.
public class MainTask2 {

    public static void main(String[] args) {
        args = new String[]{"aaa", "bbb"};
        for (int i = args.length - 1; i >= 0; i--)
        {
            System.out.println(args[i]);
        }
    }
}