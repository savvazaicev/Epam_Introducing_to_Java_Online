package com.company.string_as_array;

//В строке найти количество цифр.
class task_3 {
    public static void main(String[] args) {
        String str = "2 плюс 2 равно 4";
        char[] symbols = str.toCharArray();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(symbols[i])) {
                count++;
            }
        }
        System.out.println(count);
    }
}