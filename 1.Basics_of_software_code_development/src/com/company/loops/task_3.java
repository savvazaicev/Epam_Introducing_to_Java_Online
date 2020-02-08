package com.company.loops;

//Найти сумму квадратов первых ста чисел.
public class task_3 {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i * i;
        }
        System.out.println("Сумма квадратов первых 100 чисел: " + sum);
    }
}
