package com.company.decomposition_using_methods;

//Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.
public class task_11 {

    public static void main(String[] args) {
        int a = 12345;
        int b = 1245;
        int greaterNum = hasMoreDigits(a, b);
        if (greaterNum != 0) {
            System.out.println("число " + greaterNum + " имеет больше цифр");
        } else {
            System.out.println("Числа одинаковой длины");
        }
    }

    private static int hasMoreDigits(int a, int b) {
        if (a - b > 0) {
            return a;
        } else if (a - b < 0) {
            return b;
        } else {
            return 0;
        }
    }
}
