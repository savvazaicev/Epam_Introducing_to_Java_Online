package com.company.decomposition_using_methods;
//Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
//Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов
//массива с номерами от k до m.

// Compiler version JDK 11.0.2

class sumOfThree_8 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Суммы: " + sumOfThree(array, 1, 3) + " "
                + sumOfThree(array, 3, 5) + " " + sumOfThree(array, 4, 6));
    }

    public static int sumOfThree(int[] array, int k, int m) {
        int sum = 0;
        for (int i = k; i <= m; i++) {
            sum += array[i];
        }
        return sum;
    }
}