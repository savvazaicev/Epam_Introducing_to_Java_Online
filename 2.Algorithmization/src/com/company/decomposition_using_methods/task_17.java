package com.company.decomposition_using_methods;

//Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д.
//Сколько таких действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию.
public class task_17 {

    public static void main(String[] args) {
        int num = 21;
        int count = 0;
        while (num > 0) {
            num -= sumOfDigits(num);
            count++;
        }
        System.out.println(count);
    }

    private static int sumOfDigits(int num) {
        int n = countOfDigits(num);
        int[] nums = numToArray(num, n);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        return sum;
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
