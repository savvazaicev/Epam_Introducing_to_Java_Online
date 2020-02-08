package com.company.decomposition_using_methods;
//Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
//Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2.
//Для решения задачи использовать декомпозицию.

import java.util.ArrayList;

public class task_13 {

    public static void main(String[] args) {
        int n = 100;
        ArrayList<Integer> numsTwins = numsTwins(n, 2 * n);
        for (int i = 1; i < numsTwins.size(); i++) {
            System.out.println(numsTwins.get(i - 1) + " " + numsTwins.get(i));
        }
    }

    private static ArrayList<Integer> numsTwins(int a, int b) {
        ArrayList<Integer> primeNums = primeNums(a, b);
        ArrayList<Integer> numsTwins = new ArrayList<>();
        for (int i = 1; i < primeNums.size(); i++) {
            if (primeNums.get(i) - primeNums.get(i - 1) == 2) {
                numsTwins.add(primeNums.get(i - 1));
                numsTwins.add(primeNums.get(i));
            }
        }
        return numsTwins;
    }

    private static ArrayList<Integer> primeNums(int a, int b) {
        ArrayList<Integer> primeNums = new ArrayList<>();
        for (int i = a; i <= b; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                primeNums.add(i);
            }
        }
        return primeNums;
    }
}
