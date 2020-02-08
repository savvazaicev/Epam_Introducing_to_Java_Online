package com.company.arrays_of_arrays;

//Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце.
//Определить, какой столбец содержит максимальную сумму.
public class task_9 {

    public static void main(String[] args) {
        int n = 6;
        int sum;
        int max = 0;
        int columnWithMaxSum = 0;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = 0; j < n; j++) {
                matrix[j][i] = (int) (Math.random() * 10);
                sum += matrix[j][i];
                if (sum > max) {
                    columnWithMaxSum = i;
                }
            }
            System.out.println("Сумма чисел " + (i + 1) + "-го столбца: " + sum);
        }
        System.out.println("Столбец с максимальной суммой элементов: " + columnWithMaxSum);
        System.out.println();
        System.out.println("Матрица: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
