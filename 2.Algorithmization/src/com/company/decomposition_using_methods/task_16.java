package com.company.decomposition_using_methods;

//Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры.
//Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.
public class task_16 {

    public static void main(String[] args) {
        int n = 1;
        int sum = 0;
        for (int i = (int) Math.pow(10, n - 1); i < Math.pow(10, n); i++) {
            if (oddNums(i, n)) {
                sum += i;
            }
        }
        int numOfDigits = countOfDigits(sum);
        System.out.println("Сумма n-значных чисел с нечётными цифрами: " + sum);
        System.out.println("Кол-во четных цифр в сумме: " + evenNums(sum, numOfDigits));
    }

    private static boolean oddNums(int i, int n) {
        int[] nums = numToArray(i, n);
        boolean answer = true;
        for (int j = 0; j < n; j++) {
            if (nums[j] % 2 == 0) {
                answer = false;
                break;
            }
        }
        return answer;
    }

    private static int evenNums(int sum, int n) {
        int[] nums = numToArray(sum, n);
        int sumOfEvenNums = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                sumOfEvenNums++;
            }
        }
        return sumOfEvenNums;
    }

    private static int[] numToArray(int num, int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i != 0 ? (int) (num / Math.pow(10, n - i - 1)) % 10 : (int) (num / Math.pow(10, n - 1));
        }
        return nums;
    }

    private static int countOfDigits(int num) {
        int count = 0;
        while ((int) (num / Math.pow(10, count)) != 0) {
            count++;
        }
        return count;
    }
}
