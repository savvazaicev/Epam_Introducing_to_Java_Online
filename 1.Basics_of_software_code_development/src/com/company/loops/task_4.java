package com.company.loops;

import java.math.BigInteger;

//Составить программу нахождения произведения квадратов первых двухсот чисел.
public class task_4 {

    public static void main(String[] args) {
        BigInteger composition = BigInteger.valueOf(1);
        for (int i = 1; i <= 200; i++) {
            composition = composition.multiply(BigInteger.valueOf(i));
            composition = composition.multiply(BigInteger.valueOf(i));
        }
        System.out.println("Произведение квадратов первых 200 чисел: " + composition);
    }
}
