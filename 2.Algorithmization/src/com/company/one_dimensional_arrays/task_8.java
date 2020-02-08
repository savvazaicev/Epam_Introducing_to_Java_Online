package com.company.one_dimensional_arrays;

//Дана последовательность целых чисел от a до an.
//Образовать новую последовательность, выбросив из
//исходной те члены, которые равны min(a1, a,...,an).
public class task_8 {

    public static void main(String[] args) {
        int[] array = {3, 4, 1, 8, 6, 1, 4, 5};
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        int countOfMin = 0;
        for (int value : array) {
            if (value == min) {
                countOfMin++;
            }
        }
        int[] newArray = new int[array.length - countOfMin];
        int j = 0;
        for (int value : array) {
            if (value != min) {
                newArray[j] = value;
                j++;
            }
        }
        for (int value : newArray) {
            System.out.print(value + " ");
        }
    }
}
