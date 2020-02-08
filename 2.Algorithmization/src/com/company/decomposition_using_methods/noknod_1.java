package com.company.decomposition_using_methods;

//Написать метод(методы) для нахождения наибольшего общего делителя
//и наименьшего общего кратного двух натуральных чисел.
class noknod_1 {
    public static void main(String[] args) {
        int a = 24;
        int b = 54;
        System.out.println("nok: " + nok(a, b));
        System.out.println("nod: " + nod(a, b));
    }

    public static int nod(int a, int b) {
        int nod = -1;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0 && b % i == 0) {
                nod = i;
            }
        }
        return nod;
    }

    public static int nok(int a, int b) {
        int nod = nod(a, b);
        int nok = a * b / nod;
        return nok;
    }
}