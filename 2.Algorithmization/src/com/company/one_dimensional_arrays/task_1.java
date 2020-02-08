package com.company.one_dimensional_arrays;

//В массив A [N] занесены натуральные числа.
//Найти сумму тех элементов, которые кратны данному К.
public class task_1 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;
        int sum = 0;
        for (int value : array) {
            if (value % k == 0) {
                sum += value;
            }
        }
        System.out.println("Сумма эелементов равна: " + sum);
    }
}
