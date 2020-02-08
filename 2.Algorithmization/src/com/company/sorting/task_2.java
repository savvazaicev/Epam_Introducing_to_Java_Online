package com.company.sorting;

import java.util.Arrays;

//Даны две последовательности a1, a2, ..., an и b1, b2, ..., bm.
//Образовать из них новую последовательность чисел так,
//чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать.
public class task_2 {

    public static void main(String[] args) {
        int[] a = {3, 5, 10, 15, 20};
        int[] b = {1, 2, 4, 15, 17, 21, 25, 29};
        int originalSizeOfA = a.length;
        a = Arrays.copyOf(a, a.length + b.length);
        System.arraycopy(b, 0, a, originalSizeOfA, b.length);
        Arrays.sort(a);
        for (int value : a) {
            System.out.print(value + " ");
        }
    }
}
