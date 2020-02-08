package com.company.arrays_of_arrays;

//Сформировать случайную матрицу m x n, состоящую из нулей и единиц,
//причем в каждом столбце число единиц равно номеру столбца.
public class task_14 {

    public static void main(String[] args) {
        //кол-во столбцов не должно превышать кол-во строк из условия
        int m = 6;
        int n = 6;
        int[][] matrix = new int[m][n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            while (sum < (i + 1)) {
                int j = (int) (Math.random() * m);
                if (matrix[j][i] != 1) {
                    matrix[j][i] = 1;
                    sum++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
