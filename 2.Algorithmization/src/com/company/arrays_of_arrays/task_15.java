package com.company.arrays_of_arrays;

//Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.
public class task_15 {

    public static void main(String[] args) {
        int n = 6;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] % 2 != 0) {
                    matrix[i][j] = max;
                }
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
