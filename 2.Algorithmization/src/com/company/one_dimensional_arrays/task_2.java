package com.company.one_dimensional_arrays;

//Дана последовательность действительных чисел а1 ,а2 ,..., аn.
//Заменить все ее члены, большие данного Z, этим числом. Подсчитать количество замен.
public class task_2 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int z = 3;
        int countOfReplaсements = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > z) {
                array[i] = z;
                countOfReplaсements++;
            }
        }
        System.out.println("Количество замен: " + countOfReplaсements);
    }
}
