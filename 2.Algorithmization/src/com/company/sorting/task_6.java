package com.company.sorting;

//Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
//Делается это следующим образом: сравниваются два соседних элемента ai и ai+1.
//Если ai <= ai+1, то продвигаются на один элемент вперед.
//Если ai > ai+1, то производится перестановка и сдвигаются на один элемент назад.
//Составить алгоритм этой сортировки.
public class task_6 {

    public static void main(String[] args) {
        int[] array = {5, 3, 4, 7, 2, 1, 8, 9, 6};
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                array[i] = array[i] + array[i + 1] - (array[i + 1] = array[i]);
                for (int j = i; j > 0; j--) {
                    if (array[j] < array[j - 1]) {
                        array[j] = array[j] + array[j - 1] - (array[j - 1] = array[j]);
                    } else {
                        break;
                    }
                }
            }
        }
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}
