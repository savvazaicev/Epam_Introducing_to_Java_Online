package com.company.string_as_array;

//В строке найти количество чисел.
class task_4 {
    public static void main(String[] args) {
        String str = "50 плюс 50 равно 100";
        char[] symbols = str.toCharArray();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(symbols[i]) &&
                    ((i + 1 == str.length()) ||
                            (!Character.isDigit(symbols[i + 1])))) {
                count++;
            }
        }
        System.out.println(count);
    }
}