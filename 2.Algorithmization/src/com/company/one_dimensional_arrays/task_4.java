package com.company.one_dimensional_arrays;

//Даны действительные числа а1 ,а2 ,..., аn .
//Поменять местами наибольший и наименьший элементы.
public class task_4 {

    public static void main(String[] args) {
        int[] array = {6, 3, 7, 1, 2, 9, 4};
        int max = 0;
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(array[i], array[i - 1]);
        }
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.println(max);
        System.out.println(min);
    }
}
