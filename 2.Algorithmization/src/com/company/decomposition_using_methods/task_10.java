package com.company.decomposition_using_methods;

//Дано натуральное число N. Написать метод(методы) для формирования массива,
//элементами которого являются цифры числа N.
public class task_10 {

    public static void main(String[] args) {
        int n = 5;
        int[] array = arrayOfNum(n);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static int[] arrayOfNum(int n) {
        int[] array = {n, n, n, n, n};
        return array;
    }
}
