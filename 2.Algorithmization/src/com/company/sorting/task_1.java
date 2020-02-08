package com.company.sorting;

import java.util.Arrays;

//Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
//один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя дополнительный массив
public class task_1 {

    public static void main(String[] args) {
        int[] firstArray = {1, 2, 3, 4, 5};
        int[] secondArray = {6, 7, 8, 9, 10, 11};
        int k = 3;
        int originalSizeOfFirstArray = firstArray.length;
        firstArray = Arrays.copyOf(firstArray, firstArray.length + secondArray.length);
        System.arraycopy(firstArray, k, firstArray, k + secondArray.length, originalSizeOfFirstArray - k);
        System.arraycopy(secondArray, 0, firstArray, k, secondArray.length);
        for (int value : firstArray) {
            System.out.println(value);
        }
    }
}
