package com.company.arrays_of_arrays;

//Дана матрица. Вывести на экран все нечетные столбцы,
//у которых первый элемент больше последнего.
public class task_1 {

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {9, 8, 7}};
        int length = array[0].length;
        for (int i = 0; i < length; ) {
            if (array[i][0] > array[i][length - 1]) {
                for (int j = 0; j < length; j++) {
                    System.out.println(array[i][j]);
                }
            }
            i = i + 2;
        }
    }
}
