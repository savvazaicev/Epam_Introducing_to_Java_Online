package com.company.string_as_array;

import static java.lang.Character.*;

//Дан массив названий переменных в camelCase.
//Преобразовать названия в snake_case.
public class task_1 {
    public static void main(String[] args) {
        String[] camelCase = {"camelCase", "firstVar", "secondVar"};
        String[] snake_case = new String[camelCase.length];
        for (int i = 0; i < camelCase.length; i++) {
            int num = numOfUpperCase(camelCase[i]);
            char[] letters = new char[camelCase[i].length() + num];
            int k = 0;
            for (int j = 0; j < camelCase[i].length(); j++) {
                if ((isLowerCase(camelCase[i].charAt(j)))) {
                    letters[j + k] = camelCase[i].charAt(j);
                } else {
                    letters[j] = '_';
                    letters[j + 1] = toLowerCase(camelCase[i].charAt(j));
                    k++;
                }
            }
            snake_case[i] = String.valueOf(letters);
            System.out.println(snake_case[i]);
        }
    }

    private static int numOfUpperCase(String str) {
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (isUpperCase(str.charAt(i))) {
                num++;
            }
        }
        return num;
    }
}
