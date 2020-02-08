package com.company.one_dimensional_arrays;

//В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число.
//Если таких чисел несколько, то определить наименьшее из них.
public class task_9 {

    public static void main(String[] args) {
        int[] array = {1, 2, 5, 2, 5, 5, 4, 4, 4};
        int MaxCountOfRepeatingNums = 0;
        int max = 0;
        int varWithMaxCountOfRepeatingNums = 0;
        //максимальное кол-во повторений числа в исходном массиве
        for (int value : array) {
            int countOfRepeat = 0;
            for (int j = 1; j < array.length; j++) {
                if (value == array[j]) {
                    countOfRepeat++;
                }
            }
            if (countOfRepeat > max) {
                MaxCountOfRepeatingNums = 1;
                max = countOfRepeat;
                varWithMaxCountOfRepeatingNums = value;
            } else if (max == countOfRepeat) {
                if (value < varWithMaxCountOfRepeatingNums) {
                    varWithMaxCountOfRepeatingNums = value;
                }
                MaxCountOfRepeatingNums++;
            }
        }
        System.out.println("Ответ: " + varWithMaxCountOfRepeatingNums);
    }
}
