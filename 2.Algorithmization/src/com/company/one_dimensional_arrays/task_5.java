package com.company.one_dimensional_arrays;

//Даны целые числа а1 ,а2 ,..., аn .
//Вывести на печать только те числа, для которых аi > i.
public class task_5 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i = 4;
        for (int value : array) {
            if (value > i) {
                System.out.println(value);
            }
        }
    }
}
