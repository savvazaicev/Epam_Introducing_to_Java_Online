package com.company.arrays_of_arrays;

//Сформировать квадратную матрицу порядка n по заданному образцу(n - четное).
public class task_5 {

    public static void main(String[] args) {
        int n = 6;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][i] = j + 1;
                if (i + j > n - 1) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
