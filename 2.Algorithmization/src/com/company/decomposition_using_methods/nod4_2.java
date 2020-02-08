package com.company.decomposition_using_methods;

//Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.
class nod4_2 {
    public static void main(String[] args) {
        int a = 4;
        int b = 12;
        int c = 8;
        int d = 16;
        System.out.println("nod: " + nodOf4Nums(a, b, c, d));
    }

    public static int nodOf4Nums(int a, int b, int c, int d) {
        int nod = -1;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0 && b % i == 0 && c % i == 0 && d % i == 0) {
                nod = i;
            }
        }
        return nod;
    }
}