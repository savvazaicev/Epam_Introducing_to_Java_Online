package com.company.sorting;

import java.util.Arrays;

//Пусть даны две неубывающие последовательности действительных чисел
//a1 <= a2 <= ... <= an и b1 <= b2 <= ... <= bm.
//Требуется указать те места, на которые нужно вставлять элементы последовательности
//b1 <= b2 <= ... <= bm в первую последовательность так,
//чтобы новая последовательность оставалась возрастающей.
public class task_7 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        int[] array = {1, 2, 5, 7, 10, 12, 15, 17, 19, 20};
        int[] secondArray = {4, 8, 9, 16, 18};
        int lengthOfArray = array.length;
        array = Arrays.copyOf(array, lengthOfArray + secondArray.length);
        System.arraycopy(secondArray, 0, array, lengthOfArray, secondArray.length);
        int index = 0;
        int swapNumber = 0;
        for (int i = lengthOfArray; i < array.length; i++) {
            index = findPlace(array[i], array, lengthOfArray);
            swapNumber = array[i];
            System.arraycopy(array, index, array, index + 1, i - index);
            array[index] = swapNumber;
            lengthOfArray++;
        }
        for (int value : array) {
            boolean numbersMatched = false;
            for (int j = 0; j < secondArray.length; j++) {
                if (value == secondArray[j]) {
                    System.out.print(ANSI_RED + value + ANSI_RESET + " ");
                    j = secondArray.length;
                    numbersMatched = true;
                }
            }
            if (!numbersMatched) {
                System.out.print(value + " ");
            }
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