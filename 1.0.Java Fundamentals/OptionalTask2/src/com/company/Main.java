package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random(System.currentTimeMillis());
        int n = 0;
        System.out.println("Введите размерность матрицы n: ");
        n = in.nextInt();
        int[][] matrix = new int[n][n];
        int m = 100;
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -100 + rnd.nextInt(m + 100);
            }
        }
        System.out.println("Матрица: ");
        for (int i = 0; i < n; i++) {
            System.out.println("\n");
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] +" ");
            }
        }
        System.out.println("\n");
        int glass = 0;
        for (int l = 0; l < n - 1; l++) {
            for (int i = 1; i < n - l; i++) {
                if (matrix[i][k] < matrix[i - 1][k]) {
                    for (int j = 0; j < n; j++) {
                        glass = matrix[i][j];
                        matrix[i][j] = matrix[i - 1][j];
                        matrix[i - 1][j] = glass;
                    }
                }
            }
        }
        System.out.println("Упорядоченная Матрица: ");
        for (int i = 0; i < n; i++) {
            System.out.println("\n");
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] +" ");
            }
        }
    }
}
