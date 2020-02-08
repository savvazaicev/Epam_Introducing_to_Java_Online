package com.company.sorting;

//Сортировка выбором. Дана последовательность чисел a1 <= a2 <= ... <= an.
//Требуется переставить элементы так, чтобы они были расположены по убыванию.
//Для этого в массиве, начиная с первого, выбирается наибольший
//элемент и ставится на первое место, а первый - на место наибольшего. Затем, начиная со второго,
//эта процедура повторяется. Написать алгоритм сортировки выбором.
public class task_3 {

    public static void main(String[] args) {
        int[] array = {3, 6, 4, 1, 2, 8, 7, 9};
        for (int i = 0; i < array.length; i++) {
            int max = i;
            for (int j = 1 + i; j < array.length; j++) {
                if (array[j] > array[max]) {
                    max = j;
                }
            }
            array[i] = array[i] + array[max] - (array[max] = array[i]);
            System.out.print(array[i] + " ");
        }
    }
}
