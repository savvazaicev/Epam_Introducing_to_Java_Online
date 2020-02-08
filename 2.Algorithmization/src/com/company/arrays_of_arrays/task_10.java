package com.company.arrays_of_arrays;

//Найти положительные элементы главной диагонали квадратной матрицы.
public class task_10 {

    public static void main(String[] args) {
        int n = 6;
        int[][] matrix = new int[n][n];
        System.out.println("Матрица: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (-5 + Math.random() * 10);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Положительные элементы на главной диагонали матрицы: ");
        for (int i = 0; i < n; i++) {
            if (matrix[i][i] > 0) {
                System.out.print(matrix[i][i] + " ");
            }
        }
    }
}
