package com.company.decomposition_using_methods;

//Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число,
//которое меньше максимального элемента массива, но больше всех других элементов).
class min2_5 {
    public static void main(String[] args) {
        int[] array = {7, 9, 5, 4, 8, 1, 3, 2};
        System.out.println("Воторое по величине максимальное число: " + max2(array));
    }

    public static int max2(int[] array) {
        int max = max(array);
        int max2 = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max2 && array[i] != max) {
                max2 = array[i];
            }
        }
        return max2;
    }

    public static int max(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}