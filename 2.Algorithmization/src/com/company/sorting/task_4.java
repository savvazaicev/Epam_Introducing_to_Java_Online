package com.company.sorting;

//Сортировка обменами. Дана последовательность чисел a1 <= a2 <= ... <= an.
//Требуется переставить числа в порядке возрастания. Для этого сравниваются два соседних числа ai и ai+1.
//Если ai > ai+1, то делается перестановка. Так продолжается до тех пор,
//пока все элементы не станут расположены в порядке возрастания.
//Составить алгоритм сортировки, подсчитывая при этом количество перестановок.
public class task_4 {

    public static void main(String[] args) {
        int[] array = {5, 1, 3, 2, 8, 7, 9};
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1 + i; j < array.length; j++) {
                if (array[j] < array[j - 1]) {
                    array[j] = array[j] + array[j - 1] - (array[j - 1] = array[j]);
                    count++;
                }
            }
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.print("Кол-во перестановок: " + count);
    }
}
