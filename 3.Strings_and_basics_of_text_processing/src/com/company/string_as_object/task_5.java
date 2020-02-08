package com.company.string_as_object;

//Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.
public class task_5 {
    public static void main(String[] args) {
        String str = "Мама мыла раму";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'а') {
                count++;
            }
        }
        System.out.println(count);
    }
}
