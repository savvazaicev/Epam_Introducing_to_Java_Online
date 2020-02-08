package com.company;

import java.util.Scanner;

//Задание. Ввести n чисел с консоли.
//1.Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
//2.Вывести числа в порядке возрастания (убывания) значений их длины.
public class OptionalTask1 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        System.out.println("Введите количество чисел: ");
        count = in.nextInt();
        int[] varArray = new int[count];
        System.out.println("Введите числа разной длины");
        for (int i = 0; i < count; i++) {
            varArray[i] = in.nextInt();
        }
        int a = 0;
        int b = 0;
        int min = varArray[0];
        int max = 0;
        int minLength = 0;
        int maxLength = 0;
        int[] newVarArray = new int[count];
        //Task 1
        for (int i = 1; i < count; i++) {
            a = getCountsOfDigits(varArray[i - 1]);
            b = getCountsOfDigits(varArray[i]);
            if (a >= b) {
                if (getCountsOfDigits(min) >= b) {
                    min = varArray[i];
                    minLength = b;
                }
                if (getCountsOfDigits(max) < a) {
                    max = varArray[i - 1];
                    maxLength = a;
                }
            } else {
                if (getCountsOfDigits(min) >= a) {
                    min = varArray[i - 1];
                    minLength = a;
                }
                if (getCountsOfDigits(max) < b) {
                    max = varArray[i];
                    maxLength = b;
                }
            }
        }
        //Task 2
        int[] countOfArrayDigits = new int[count];
        int[] sortedArray = new int[count];
        int glass = 0;
        for (int i = 0; i < count; i++) {
            countOfArrayDigits[i] = getCountsOfDigits(varArray[i]);
            sortedArray[i] = varArray[i];
        }
        for (int j = 0; j < count - 1; j++) {
            for (int i = 1; i < count - j; i++) {
                if (countOfArrayDigits[i - 1] > countOfArrayDigits[i]) {
                    glass = sortedArray[i - 1];
                    sortedArray[i - 1] = sortedArray[i];
                    sortedArray[i] = glass;
                    glass = countOfArrayDigits[i - 1];
                    countOfArrayDigits[i - 1] = countOfArrayDigits[i];
                    countOfArrayDigits[i] = glass;
                }
            }
        }
        System.out.println("Самое короткое число: " + min);
        System.out.println("Его длина: " + minLength);
        System.out.println("Самое длинное число: " + max);
        System.out.println("Его длина: " + maxLength);
        System.out.println("Числа в порядке возрастания значений их длинны: ");
        for (int i = 0; i < count; i++) {
            System.out.println(sortedArray[i]);
        }
    }

    public static int getCountsOfDigits(int number) {
        int countOfNumbers = (number == 0) ? 1 : 0;
        while (number != 0) {
            countOfNumbers++;
            number /= 10;
        }
        return countOfNumbers;
    }
}
