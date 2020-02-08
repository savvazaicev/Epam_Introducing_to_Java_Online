package com.company.one_dimensional_arrays;

//Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из него каждый второй
//элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать
public class task_10 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 1; i < array.length; ) {
            array[i] = 0;
            i = i + 2;
        }
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
