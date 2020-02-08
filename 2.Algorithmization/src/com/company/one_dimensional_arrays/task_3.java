package com.company.one_dimensional_arrays;

//Дан массив действительных чисел, размерность которого N. Подсчитать,
//сколько в нем отрицательных, положительных и нулевых элементов.
public class task_3 {

    public static void main(String[] args) {
        int[] array = {-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = array.length;
        int zeros = 0;
        int negativeVars = 0;
        int positiveVars = 0;
        for (int value : array) {
            if (value == 0) {
                zeros++;
            } else if (value < 0) {
                negativeVars++;
            } else {
                positiveVars++;
            }
        }
        System.out.println("Кол-во отрицательных чисел: " + negativeVars);
        System.out.println("Кол-во положительных чисел: " + positiveVars);
        System.out.println("Кол-во нулевых элементов: " + zeros);
    }
}
