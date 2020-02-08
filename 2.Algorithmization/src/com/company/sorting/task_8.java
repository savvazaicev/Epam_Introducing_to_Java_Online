package com.company.sorting;

//Даны дроби (pi, qi - натуральные). Составить программу,
//которая приводит эти дроби к общему знаменателю и упорядочивает их в порядке возрастания.
public class task_8 {

    public static void main(String[] args) {
        int[][] fractions = {{3, 4}, {1, 2}, {1, 3}, {3, 2}, {3, 5}};
        int nok = fractions[0][1];
        for (int i = 1; i < fractions.length; i++) {
            nok = getNok(nok, fractions[i][1]);
        }
        for (int i = 0; i < fractions.length; i++) {
            fractions[i][0] *= (double) nok / fractions[i][1];
            fractions[i][1] = nok;
        }
        for (int i = 0; i < fractions.length; i++) {
            int min = fractions[i][0];
            int indexOfMin = -1;
            for (int j = i + 1; j < fractions.length; j++) {
                if (fractions[j][0] < min) {
                    min = fractions[j][0];
                    indexOfMin = j;
                }
            }
            if (indexOfMin != -1) {
                fractions[i][0] = fractions[i][0] + fractions[indexOfMin][0] - (fractions[indexOfMin][0] = fractions[i][0]);
            }
            System.out.print(fractions[i][0] + "/" + fractions[i][1] + " ");
        }
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

    public static int getNok(int a, int b) {
        int nod = nod(a, b);
        return a * b / nod;
    }
}