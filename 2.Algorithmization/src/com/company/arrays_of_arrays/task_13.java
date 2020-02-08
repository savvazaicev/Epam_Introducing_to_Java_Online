package com.company.arrays_of_arrays;

//Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов.
public class task_13 {

    public static void main(String[] args) {
        int n = 5;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        System.out.println("Исходная матрица: ");
        matrixOutput(matrix, n);
        System.out.println("Матрица, отсортированная по возрастанию значений элементов столбцов: ");
        matrixSort(matrix, n, true);
        matrixOutput(matrix, n);
        System.out.println("Матрица, отсортированная по убыванию значений элементов столбцов: ");
        matrixSort(matrix, n, false);
        matrixOutput(matrix, n);
    }

    public static void matrixOutput(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void matrixSort(int[][] matrix, int n, boolean ascending) {
        int temp;
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                for (int j = 1; j < n - k; j++) {
                    if (ascending) {
                        if (matrix[j - 1][i] > matrix[j][i]) {
                            temp = matrix[j - 1][i];
                            matrix[j - 1][i] = matrix[j][i];
                            matrix[j][i] = temp;
                        }
                    } else {
                        if (matrix[j - 1][i] < matrix[j][i]) {
                            temp = matrix[j - 1][i];
                            matrix[j - 1][i] = matrix[j][i];
                            matrix[j][i] = temp;
                        }
                    }
                }
            }
        }
    }
}
