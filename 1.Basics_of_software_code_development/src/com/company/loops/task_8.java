package com.company.loops;

//Даны два числа. Определить цифры, входящие в запись как первого так и второго числа.
public class task_8 {
    public static int getCountsOfDigits(int number) {
        int count = (number == 0) ? 1 : 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        int x = 239486;
        int y = 983756;
        int xNumber = 0;
        int yNumber = 0;
        int lengthX = getCountsOfDigits(x);
        int lengthY = getCountsOfDigits(y);
        System.out.println("Цифры, входящие в запись обоих чисел: ");
        for (int i = 1; i <= lengthX; i++) {
            xNumber = (int) (x % Math.pow(10, i) / Math.pow(10, i - 1));
            for (int j = 1; j <= lengthY; j++) {
                yNumber = (int) (y % Math.pow(10, j) / Math.pow(10, j - 1));
                if (xNumber == yNumber) {
                    System.out.print(xNumber + " ");
                }
            }
        }
    }
}
