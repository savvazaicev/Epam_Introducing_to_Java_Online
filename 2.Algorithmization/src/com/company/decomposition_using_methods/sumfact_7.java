package com.company.decomposition_using_methods;

//Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.
class sumfact_7 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Сумма факториалов нечетных чисел: " + sumOddFact(array));
    }

    public static int sumOddFact(int[] array) {
        int sumOddFact = 0;
        for (int i = 1; i <= array.length; i++) {
            if (i % 2 == 1) {
                int fact = 1;
                for (int j = 2; j <= i; j++) {
                    fact *= j;
                }
                sumOddFact += fact;
            }
        }
        return sumOddFact;
    }
}