package com.company.string_as_object;

//Проверить, является ли заданное слово палиндромом.
public class task_3 {
    public static void main(String[] args) {
        String word = "мадам";
        boolean isPolindrom = true;
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                isPolindrom = false;
                break;
            }
        }
        System.out.println(isPolindrom);
    }
}
