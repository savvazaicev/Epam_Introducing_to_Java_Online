package com.company.arrays_of_arrays;

//Магическим квадратом порядка n называется квадратная матрица размера nxn,
//составленная из чисел 1, 2, 3,...,n2 так, что суммы по каждому столбцу,
//каждой строке и каждой из двух больших диагоналей равны между собой. Построить такой квадрат.
public class task_16 {

    public static void main(String[] args) {
        int n = 3;
        int sumOfMagicSquare = 15;
        System.out.println("Подождите несколько секунд...");
        int[][] matrix = new int[n][n];
        fillMatrix(matrix, n);
        while (!magicSquareCheck(matrix, n, sumOfMagicSquare)) {
            fillMatrix(matrix, n);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void fillMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (n * n + 1 - Math.random() * n * n);
            }
        }
    }

    public static boolean magicSquareCheck(int[][] matrix, int n, int sumOfMagicSquare) {
        int[] sum = new int[2 * n + 2];
        for (int k = 0; k < 2 * n + 2; k++) {
            sum[k] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[2 * n - 1 - i] += matrix[i][j];
                sum[n - 1 - i] += matrix[j][i];
                if (i == j) {
                    sum[2 * n] += matrix[i][j];
                }
                if (i == n - j - 1) {
                    sum[2 * n + 1] += matrix[i][j];
                }
            }
        }
        for (int k = 0; k < 2 * n + 2; k++) {
            if (sum[k] != sumOfMagicSquare) {
                return false;
            }
        }
        return true;
    }
}
