package com.company.arrays_of_arrays;

//Сформировать квадратную матрицу порядка N по правилу.
public class task_7 {

    public static void main(String[] args) {
        int n = 5;
        int count = 0;
        double[][] matrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Math.sin((i * i - j * j) / n);
                if (matrix[i][j] > 0) {
                    count++;
                }
            }
        }
        System.out.println("Кол-во положительных элементов матрицы: " + count);
        System.out.println("Проверка, округление матрицы в большую сторону: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) Math.ceil(matrix[i][j]);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
