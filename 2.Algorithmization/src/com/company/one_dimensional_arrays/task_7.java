package com.company.one_dimensional_arrays;

//Даны действительные числа от a до an.
//Найти max(a1 + a2n, a2 + a2n−1,...,an + an+1)
public class task_7 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 4, 5};
        int max = array[0] + array[1];
        for (int i = 1; i < array.length - 1; i++) {
            int couple = array[i] + array[i + 1];
            if (couple > max) {
                max = couple;
            }
        }
        System.out.println(max);
    }
}
