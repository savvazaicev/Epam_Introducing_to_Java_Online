package com.company.decomposition_using_methods;

//Даны натуральные числа К и N. Написать метод(методы) формирования массива А,
//элементами которого являются числа, сумма цифр которых равна К и которые не большее N.
public class task_12 {

    public static void main(String[] args) {
        int k = 7;
        int n = 6;
        int arrayLength = 5;
        int[] array = createArray(k, n, arrayLength);
        for (int i = 0; i < arrayLength; i++) {
            System.out.println(array[i]);
        }
    }

    private static int[] createArray(int k, int n, int arrayLength) {
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength && i < n; i++) {
            array[i] = n - i;
        }
        return array;
    }
}
