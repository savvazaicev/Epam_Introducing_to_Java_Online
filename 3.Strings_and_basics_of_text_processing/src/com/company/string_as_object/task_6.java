package com.company.string_as_object;

//Из заданной строки получить новую, повторив каждый символ дважды.
public class task_6 {
    public static void main(String[] args) {
        String str = "Мама мыла раму";
        String newStr = str.substring(0, 1) + str.substring(0, 1);
        for (int i = 1; i < str.length(); i++) {
            newStr = newStr + str.substring(i, i + 1) + str.substring(i, i + 1);
        }
        System.out.println(newStr);
    }
}
