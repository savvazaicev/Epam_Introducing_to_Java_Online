package com.company.one_dimensional_arrays;

//Задана последовательность N вещественных чисел.
//Вычислить сумму чисел, порядковые номера которых являются простыми числами.
public class task_6 {

    public static void main(String[] args) {
        double[] array = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 1.0};
        double sum = 0;
        //int lengthArrayMinOne = array.length - 1;
        for (int i = 2; i < array.length; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sum += array[i];
            }
        }
        System.out.println(sum);
    }
}
