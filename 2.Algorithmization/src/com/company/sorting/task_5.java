package com.company.sorting;

import java.util.Arrays;

//Сортировка вставками. Дана последовательность чисел a1, a2, ..., an.
//Требуется переставить числа в порядке возрастания. Делается это следующим образом.
//Пусть a1, a2, ..., ai - упорядоченная последовательность, т. е. a1<=a2<=...<=an.
//Берется следующее число ai+1 и вставляется в последовательность так, чтобы новая
//последовательность была тоже возрастающей. Процесс производится до тех пор, пока все элементы от i+1 до n
//не будут перебраны. Примечание. Место помещения очередного элемента в отсортированную часть производить
//с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.
public class task_5 {

    public static void main(String[] args) {
        int[] array = {1, 2, 5, 7, 10, 12, 15, 17, 19, 20, 9, 4, 16, 18, 8};
        int lengthOfSortedPart = 10;
        int index = 0;
        int swapNumber = 0;
        for (int i = lengthOfSortedPart; i < array.length; i++) {
            index = findPlace(array[i], array, lengthOfSortedPart);
            swapNumber = array[i];
            System.arraycopy(array, index, array, index + 1, i - index);
            array[index] = swapNumber;
            lengthOfSortedPart++;
        }
        for (int value : array) {
            System.out.print(value + " ");
        }
    }

    private static int findPlace(int num, int[] array, int lengthOfSortedPart) {
        int[] sortedPart = Arrays.copyOf(array, lengthOfSortedPart);
        int placeInArray = 0;
        while (sortedPart.length != 1) {
            int halfLength = sortedPart.length / 2;
            if (sortedPart[halfLength] == num) {
                break;
            } else if (sortedPart[halfLength] < num) {
                int i = 1;
                if (sortedPart.length % 2 == 0) {
                    i = 0;
                }
                System.arraycopy(sortedPart, halfLength + i, sortedPart, 0, halfLength);
                sortedPart = Arrays.copyOf(sortedPart, halfLength);
            } else {
                sortedPart = Arrays.copyOf(sortedPart, halfLength);
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (sortedPart[0] == array[i]) {
                placeInArray = i + 1;
            }
        }
        return placeInArray;
    }
}
