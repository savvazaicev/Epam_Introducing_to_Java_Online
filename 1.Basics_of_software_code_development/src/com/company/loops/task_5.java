package com.company.loops;

//Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда,
//модуль которых больше или равен заданному е.
public class task_5 {

    public static void main(String[] args) {
        double e = 0.001;
        double row = 0;
        double sum = 0;
        for (int i = 1; ; i++) {
            row = 1 / Math.pow(2, i) + 1 / Math.pow(3, i);
            if (row > e) {
                sum += row;
            } else {
                System.out.println("Сумма членов ряда больших чем " + e + " = " + sum);
                System.exit(0);
            }
        }
    }
}
