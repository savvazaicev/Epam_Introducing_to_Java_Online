package com.company.arrays_of_arrays;

//Сформировать квадратную матрицу порядка n по заданному образцу(n - четное).
public class task_6 {

    public static void main(String[] args) {
        int n = 6;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i - j > 0 && n - i - j > 1 ||
                        n - i - j <= 0 && j - i > 0) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = 1;
                }
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
