package com.company.arrays_of_arrays;
//Сформировать квадратную матрицу порядка n по заданному образцу(n - четное).

import java.util.Scanner;

public class task_4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите n: ");
        int n = in.nextInt();
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = j + 1;
                }
            } else {
                for (int j = 0; j < n; j++) {
                    array[i][j] = n - j;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
