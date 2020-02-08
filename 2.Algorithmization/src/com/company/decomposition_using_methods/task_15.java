package com.company.decomposition_using_methods;

//Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую
//последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию.
public class task_15 {

    public static void main(String[] args) {
        int n = 6;
        for (int i = (int) Math.pow(10, n - 1); i < Math.pow(10, n); i++) {
            if (numsIncreasing(i, n)) {
                System.out.println(i);
            }
        }
    }

    private static boolean numsIncreasing(int num, int n) {
        int[] nums = numToArray(num, n);
        boolean numsIncreasing = true;
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                numsIncreasing = false;
                break;
            }
        }
        return numsIncreasing;
    }

    private static int[] numToArray(int num, int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i != 0 ? (int) (num / Math.pow(10, n - i - 1)) % 10 : (int) (num / Math.pow(10, n - 1));
        }
        return nums;
    }
}
