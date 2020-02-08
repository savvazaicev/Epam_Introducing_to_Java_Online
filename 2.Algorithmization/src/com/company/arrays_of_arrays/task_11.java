package com.company.arrays_of_arrays;

//Матрицу 10x20 заполнить случайными числами от 0 до 15.
//Вывести на экран саму матрицу и номера строк,
//в которых число 5 встречается три и более раз.
public class task_11 {

    public static void main(String[] args) {
        int[][] matrix = new int[10][20];
        int countOfNumbersFive;
        System.out.println("Номера строк, в которых число 5 встречается три и более раз: ");
        for (int i = 0; i < 10; i++) {
            countOfNumbersFive = 0;
            for (int j = 0; j < 20; j++) {
                matrix[i][j] = (int) (Math.random() * 15);
                if (matrix[i][j] == 5) {
                    countOfNumbersFive++;
                }
            }
            if (countOfNumbersFive >= 3) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
        System.out.println("Матрица: ");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
