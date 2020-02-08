package com.company.arrays_of_arrays;

import java.util.Scanner;

//В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
//на соответствующие им позиции другого, а его элементы второго переместить в первый.
//Номера столбцов вводит пользователь с клавиатуры.
public class task_8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 6;
        System.out.println("Введите номера стобцов от 1 до 6, которые нужно поменять местами:");
        int firstColumn = in.nextInt() - 1;
        int secondColumn = in.nextInt() - 1;
        System.out.println("Исходная матрица: ");
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Искомая матрица: ");
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp = matrix[i][firstColumn];
            matrix[i][firstColumn] = matrix[i][secondColumn];
            matrix[i][secondColumn] = tmp;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
