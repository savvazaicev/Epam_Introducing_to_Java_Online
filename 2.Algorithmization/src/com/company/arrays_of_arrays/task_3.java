package com.company.arrays_of_arrays;

//Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
public class task_3 {

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 2;
        int p = 1;
        System.out.println("k-ая строка: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[k][i] + " ");
        }
        System.out.println();
        System.out.println("p-й столбец: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i][p] + " ");
        }
    }
}
