package com.company.arrays_of_arrays;

//Дана квадратная матрица.
//Вывести на экран элементы, стоящие на диагонали.
public class task_2 {

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i][i]);
        }
    }
}
