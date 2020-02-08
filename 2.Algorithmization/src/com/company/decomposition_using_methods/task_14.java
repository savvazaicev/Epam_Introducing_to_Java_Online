package com.company.decomposition_using_methods;

//Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр,
//возведенная в степень n, равна самому числу. Найти все числа Армстронга от 1 до k.
//Для решения задачи использовать декомпозицию.
public class task_14 {

    public static void main(String[] args) {
        int k = 1000;
        for (int i = 0; i < k; i++) {
            if (amstrongNum(i)) {
                System.out.println(i);
            }
        }
    }

    private static Boolean amstrongNum(int num) {
        int numOfDigits = 1;
        while ((int) (num / Math.pow(10, numOfDigits)) != 0) {
            numOfDigits++;
        }

        int sumOfNums = 0;
        for (int i = 1; i <= numOfDigits; i++) {
            sumOfNums += num % Math.pow(10, i) / Math.pow(10, i - 1);
        }

        return Math.pow(sumOfNums, numOfDigits) == num;
    }
}
