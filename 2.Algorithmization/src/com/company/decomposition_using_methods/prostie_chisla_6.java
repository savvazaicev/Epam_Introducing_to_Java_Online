package com.company.decomposition_using_methods;

//Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.
class prostie_chisla_6 {
    public static void main(String[] args) {
        int a = 14;
        int b = 25;
        int c = 9;
        //int b = 21;
        //int c = 7;
        if (isPrimeNums(a, b, c)) {
            System.out.println("Числа являются взаимно простыми");
        } else {
            System.out.println("Числп не являются взаимно простыми");
        }
    }

    public static Boolean isPrimeNums(int a, int b, int c) {
        boolean isPrimeNums = true;
        for (int i = 2; i < a; i++) {
            if (a % i == 0 && b % i == 0 && c % i == 0) {
                isPrimeNums = false;
                break;
            }
        }
        return isPrimeNums;
    }
}